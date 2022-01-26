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
 * 系统用户 服务层实现
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
     * 管理系统用户登录
     *
     * @param systemUserDTO 登录用户信息
     * @return 系统用户
     */
    @Override
    public SystemUserVO login(SystemUserDTO systemUserDTO) {
        SystemUser systemUser = systemUserMapper.getByUsername(systemUserDTO.getUsername());
        // 用户名不存在
        if (systemUser == null) {
            throw new PrivateException(LOGIN_ERROR);
        } else if (systemUser.getStatus() == SystemUserStatusConstant.FREEZE) {
            throw new PrivateException(ErrorInfoEnum.USER_LOCKED);
        }
        // 检查用户密码 暂时使用 可优化
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
     * 根据用户id查询拥有的权限
     *
     * @param userId 系统用户id
     * @return 后端权限url
     */
    @Override
    public Set<String> listPermissionsByUserId(Long userId) {
        return systemUserMapper.selectPermissionByUserId(userId);
    }

    /**
     * 根据用户id修改用户状态
     *
     * @param userId 用户id
     * @param status 状态 {@link SystemUserStatusConstant}
     */
    @Override
    @Transactional
    public void updateStatus(Long userId, int status) {
        int count = systemUserMapper.updateStatusById(userId, status);
        if (count != 1) {
            throw new PrivateException(ErrorInfoEnum.UPDATE_ERROR);
        }
        // 冻结,同时清空token
        if (status == SystemUserStatusConstant.FREEZE) {
            redisService.deleteSystemLogin(userId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SystemUserRoleDTO systemUserRoleDTO) {
        SystemUser systemUser = systemUserRoleDTO.getSystemUser();
        // 校验登录名是否重复
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
            // 修改时如果填写密码则修改密码
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
     * 查询系统用户信息
     *
     * @param id 系统用户ID
     * @return 系统用户信息
     */
    @Override
    public SystemUserRoleVO selectSystemUserById(Long id) {
        SystemUserRoleVO systemUserRoleVO = new SystemUserRoleVO();
        systemUserRoleVO.setSystemUser(systemUserMapper.selectSystemUserById(id));
        systemUserRoleVO.setRoleId(systemUserRoleMapper.selectSystemRoleByUserId(id));
        return systemUserRoleVO;
    }

    /**
     * 查询系统用户列表
     *
     * @param systemUser 系统用户信息
     * @return 系统用户集合
     */
    @Override
    public List<SystemUser> selectSystemUserList(SystemUser systemUser) {
        return systemUserMapper.selectSystemUserList(systemUser);
    }

    /**
     * 新增系统用户
     *
     * @param systemUser 系统用户信息
     * @return 返回带有id的用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemUser insertSystemUser(SystemUser systemUser) {
        int count = systemUserMapper.insertSystemUser(systemUser);
        if (count != 1) {
            log.info("用户保存失败！用户信息：{}", systemUser);
            throw new PrivateException(ErrorInfoEnum.ADD_ERROR);
        }
        return systemUser;
    }

    /**
     * 修改系统用户
     *
     * @param systemUser 系统用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSystemUser(SystemUser systemUser) {
        return systemUserMapper.updateSystemUser(systemUser);
    }

    /**
     * 删除系统用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
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
     * 检查用户id是否可用
     * @param userIds
     */
    private void checkUserIds(List<Long> userIds) {
        int count = systemUserMapper.countSystemUserByIds(userIds);
        if (count != userIds.size()) {
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }
    }
}
