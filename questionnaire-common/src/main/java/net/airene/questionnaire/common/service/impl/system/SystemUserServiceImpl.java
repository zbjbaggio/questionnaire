package net.airene.questionnaire.common.service.impl.system;

import com.github.pagehelper.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.constant.system.SystemUserStatusConstant;
import net.airene.questionnaire.common.data.DTO.system.SystemRoleUserDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemUserDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemUserRoleDTO;
import net.airene.questionnaire.common.data.DTO.system.UserQueryDTO;
import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.data.VO.system.MenuAndButtonVO;
import net.airene.questionnaire.common.data.VO.system.SystemUserRoleVO;
import net.airene.questionnaire.common.data.VO.system.SystemUserVO;
import net.airene.questionnaire.common.data.VO.system.UserRoleIdVO;
import net.airene.questionnaire.common.data.entity.system.SystemRole;
import net.airene.questionnaire.common.data.entity.system.SystemUser;
import net.airene.questionnaire.common.data.entity.system.SystemUserRole;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import net.airene.questionnaire.common.mapper.system.SystemRoleMapper;
import net.airene.questionnaire.common.mapper.system.SystemUserMapper;
import net.airene.questionnaire.common.mapper.system.SystemUserRoleMapper;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.service.system.SystemPermissionService;
import net.airene.questionnaire.common.service.system.SystemUserService;
import net.airene.questionnaire.common.util.JwtUtil;
import net.airene.questionnaire.common.util.PasswordUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static net.airene.questionnaire.common.enums.ErrorInfoEnum.LOGIN_ERROR;

/**
 * ???????????? ???????????????
 *
 * @author eason
 * @date 2020-03-06
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SystemUserServiceImpl implements SystemUserService {

    private final SystemUserMapper systemUserMapper;

    private final SystemPermissionService systemPermissionService;

    private final RedisService redisService;

    private final SystemUserRoleMapper systemUserRoleMapper;

    private final SystemRoleMapper systemRoleMapper;

    private final JwtUtil jwtUtil;

    /**
     * ????????????????????????
     *
     * @param systemUserDTO ??????????????????
     * @return ????????????
     */
    @Override
    public SystemUserVO login(SystemUserDTO systemUserDTO) {
        SystemUser systemUser = systemUserMapper.getByUsername(systemUserDTO.getUsername());
        // ??????????????????
        if (systemUser == null) {
            throw new PrivateException(LOGIN_ERROR);
        } else if (systemUser.getStatus() == SystemUserStatusConstant.FREEZE) {
            throw new PrivateException(ErrorInfoEnum.USER_LOCKED);
        }
        // ?????????????????? ???????????? ?????????
        String password = PasswordUtil.encrypt(systemUser.getUsername(), systemUserDTO.getPassword(), systemUser.getSalt());
        if (!systemUser.getPassword().equals(password)) {
            throw new PrivateException(ErrorInfoEnum.LOGIN_ERROR);
        }
        SystemUserVO systemUserVO = new SystemUserVO();
        MenuAndButtonVO menu = systemPermissionService.getMenu(systemUser.getId());
        BeanUtils.copyProperties(menu, systemUserVO);
        systemUserVO.setId(systemUser.getId());
        systemUserVO.setUsername(systemUser.getUsername());
        systemUserVO.setToken(jwtUtil.sign(String.valueOf(systemUserVO.getId())));
        redisService.saveSystemLogin(systemUserVO);
        redisService.deletePermission(systemUser.getId());
        systemUserVO.setPermissionSet(null);
        return systemUserVO;
    }

    /**
     * ????????????id?????????????????????
     *
     * @param userId ????????????id
     * @return ????????????url
     */
    @Override
    public Set<String> listPermissionsByUserId(Long userId) {
        return systemUserMapper.selectPermissionByUserId(userId);
    }

    /**
     * ????????????id??????????????????
     *
     * @param userId ??????id
     * @param status ?????? {@link SystemUserStatusConstant}
     */
    @Override
    @Transactional
    public void updateStatus(Long userId, int status) {
        int count = systemUserMapper.updateStatusById(userId, status);
        if (count != 1) {
            throw new PrivateException(ErrorInfoEnum.UPDATE_ERROR);
        }
        // ??????,????????????token
        if (status == SystemUserStatusConstant.FREEZE) {
            redisService.deleteSystemLogin(userId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SystemUserRoleDTO systemUserRoleDTO) {
        SystemUser systemUser = systemUserRoleDTO.getSystemUser();
        // ???????????????????????????
        checkUsernameByUserId(systemUser.getUsername(), systemUser.getId());
        checkRoleIds(systemUserRoleDTO.getRoleIds());
        Long userId = systemUser.getId();
        if (Objects.isNull(systemUser.getId())) {
            setPassword(systemUser);
            systemUser.setCreateTime(LocalDateTime.now());
            systemUser.setStatus(SystemUserStatusConstant.UNFREEZE);
            SystemUser saveSystemUser = insertSystemUser(systemUser);
            userId = saveSystemUser.getId();
        } else {
            // ??????????????????????????????????????????
            if (!StringUtil.isEmpty(systemUser.getPassword())) {
                setPassword(systemUser);
            }
            systemUser.setUsername(null);
            systemUser.setStatus(null);
            updateSystemUser(systemUser);
            systemUserRoleMapper.deleteSystemUserRoleByUserId(userId);
        }
        systemUserRoleMapper.batchInsertSystemUserRole(getSystemUserRoles(systemUserRoleDTO, userId));
    }

    @Override
    public List<SystemUser> listHasUserList(Long roleId) {
        return systemUserMapper.selectHasUserList(roleId);
    }

    @Override
    public List<UserRoleIdVO> selectSystemUserAllList(UserQueryDTO userQueryDTO) {
        return systemUserMapper.selectSystemUserAllList(userQueryDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUsers(SystemRoleUserDTO systemRoleUserDTO) {
        List<Long> userIds = systemRoleUserDTO.getUserIds();
        Long roleId = systemRoleUserDTO.getRoleId();
        if (userIds != null && userIds.size() > 0) {
            checkUserIds(userIds);
        }
        SystemRole systemRole = systemRoleMapper.selectSystemRoleById(roleId);
        if (Objects.isNull(systemRole) ) {
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }
        systemUserRoleMapper.deleteSystemUserRoleByRoleId(roleId);
        if (userIds != null && userIds.size() > 0) {
            List<SystemUserRole> saves = new ArrayList<>();
            userIds.stream().forEach(userId -> {
                SystemUserRole systemUserRole = new SystemUserRole();
                systemUserRole.setCreateTime(LocalDateTime.now());
                systemUserRole.setUserId(userId);
                systemUserRole.setRoleId(roleId);
                saves.add(systemUserRole);
            });
            systemUserRoleMapper.batchInsertSystemUserRole(saves);
        }
    }

    /**
     * ????????????????????????
     *
     * @param id ????????????ID
     * @return ??????????????????
     */
    @Override
    public SystemUserRoleVO selectSystemUserById(Long id) {
        SystemUserRoleVO systemUserRoleVO = new SystemUserRoleVO();
        systemUserRoleVO.setSystemUser(systemUserMapper.selectSystemUserById(id));
        systemUserRoleVO.setRoleId(systemUserRoleMapper.selectSystemRoleByUserId(id));
        return systemUserRoleVO;
    }

    /**
     * ????????????????????????
     *
     * @param systemUser ??????????????????
     * @return ??????????????????
     */
    @Override
    public List<SystemUser> selectSystemUserList(SystemUser systemUser) {
        return systemUserMapper.selectSystemUserList(systemUser);
    }

    /**
     * ??????????????????
     *
     * @param systemUser ??????????????????
     * @return ????????????id???????????????
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemUser insertSystemUser(SystemUser systemUser) {
        int count = systemUserMapper.insertSystemUser(systemUser);
        if (count != 1) {
            log.info("????????????????????????????????????{}", systemUser);
            throw new PrivateException(ErrorInfoEnum.ADD_ERROR);
        }
        return systemUser;
    }

    /**
     * ??????????????????
     *
     * @param systemUser ??????????????????
     * @return ??????
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSystemUser(SystemUser systemUser) {
        return systemUserMapper.updateSystemUser(systemUser);
    }

    /**
     * ????????????????????????
     *
     * @param ids ?????????????????????ID
     * @return ??????
     */
    @Override
    public int deleteSystemUserByIds(Long[] ids) {
        return systemUserMapper.deleteSystemUserByIds(ids);
    }

    public void checkUsernameByUserId(String username, Long userId) {
        Integer isSameUsername = systemUserMapper.checkUserInfoNoStateNoId(username, userId);
        if (Objects.nonNull(isSameUsername)) {
            throw new PrivateException(ErrorInfoEnum.USERNAME_SAME);
        }
    }

    public void checkRoleIds(List<Long> roleIds) {
        int count = systemRoleMapper.checkId(roleIds);
        if (count != roleIds.size()) {
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }
    }

    private void setPassword(SystemUser systemUser) {
        String salt = PasswordUtil.getSalt();
        systemUser.setSalt(salt);
        systemUser.setPassword(PasswordUtil.encrypt(systemUser.getUsername(), systemUser.getPassword(), salt));
    }

    private List<SystemUserRole> getSystemUserRoles(SystemUserRoleDTO systemUserRoleDTO, Long userId) {
        List<Long> roleIds = systemUserRoleDTO.getRoleIds();
        List<SystemUserRole> systemUserRoles = new ArrayList<>(roleIds.size());
        LocalDateTime now = LocalDateTime.now();
        roleIds.stream().forEach(roleId -> {
            SystemUserRole systemUserRole = new SystemUserRole();
            systemUserRole.setRoleId(roleId);
            systemUserRole.setCreateTime(now);
            systemUserRole.setUserId(userId);
            systemUserRoles.add(systemUserRole);
        });
        return systemUserRoles;
    }

    /**
     * ????????????id????????????
     * @param userIds
     */
    private void checkUserIds(List<Long> userIds) {
        int count = systemUserMapper.countSystemUserByIds(userIds);
        if (count != userIds.size()) {
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }
    }
}
