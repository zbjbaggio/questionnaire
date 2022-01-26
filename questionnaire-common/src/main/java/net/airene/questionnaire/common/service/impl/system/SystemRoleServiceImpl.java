package net.airene.questionnaire.common.service.impl.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.constant.system.SystemRoleStatusConstant;
import net.airene.questionnaire.common.data.DTO.system.SystemRoleDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemRolePermissionDTO;
import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.data.VO.system.RoleVO;
import net.airene.questionnaire.common.data.entity.system.SystemRole;
import net.airene.questionnaire.common.data.entity.system.SystemRolePermission;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import net.airene.questionnaire.common.mapper.system.SystemPermissionMapper;
import net.airene.questionnaire.common.mapper.system.SystemRoleMapper;
import net.airene.questionnaire.common.mapper.system.SystemRolePermissionMapper;
import net.airene.questionnaire.common.mapper.system.SystemUserRoleMapper;
import net.airene.questionnaire.common.service.system.SystemPermissionService;
import net.airene.questionnaire.common.service.system.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 角色 服务层实现
 *
 * @author eason
 * @date 2020-03-06
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class SystemRoleServiceImpl implements SystemRoleService {

	private final SystemRoleMapper systemRoleMapper;

	private final SystemRolePermissionMapper systemRolePermissionMapper;

	private final SystemPermissionService systemPermissionService;

	private final SystemPermissionMapper systemPermissionMapper;

	private final SystemUserRoleMapper systemUserRoleMapper;

	/**
     * 查询角色信息
     *
     * @param id 角色ID
     * @return 角色信息
     */
    @Override
	public SystemRole selectSystemRoleById(Long id) {
	    return systemRoleMapper.selectSystemRoleById(id);
	}

	/**
     * 查询角色列表
     *
     * @param systemRoleDTO 角色信息
     * @return 角色集合
     */
	@Override
	public List<SystemRoleDTO> selectSystemRoleList(SystemRoleDTO systemRoleDTO) {
	    return systemRoleMapper.selectSystemRoleList(systemRoleDTO);
	}

    /**
     * 新增角色
     *
     * @param systemRole 角色信息
     * @return 结果
     */
	@Override
	public SystemRole insertSystemRole(SystemRole systemRole) {
		int count = systemRoleMapper.insertSystemRole(systemRole);
		if (count != 1) {
			log.info("角色保存失败！角色信息：{}", systemRole);
			throw new PrivateException(ErrorInfoEnum.ADD_ERROR);
		}
		return systemRole;
	}

	/**
     * 修改角色
     *
     * @param systemRole 角色信息
     * @return 结果
     */
	@Override
	public int updateSystemRole(SystemRole systemRole) {
	    return systemRoleMapper.updateSystemRole(systemRole);
	}

	/**
     * 删除角色对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSystemRoleByIds(Long[] ids) {
		return systemRoleMapper.deleteSystemRoleByIds(ids);
	}

	@Override
	@Transactional
	public void save(SystemRolePermissionDTO systemRolePermissionDTO) {
		SystemRole systemRole = systemRolePermissionDTO.getSystemRole();
		Long id = systemRole.getId();
		checkUsernameByUserId(systemRole.getName(), id);
		List<Long> permissionIds = systemRolePermissionDTO.getPermissionIds();
		checkPermissionIds(permissionIds);
		if (Objects.isNull(id)) {
			systemRole.setStatus(SystemRoleStatusConstant.UNFREEZE);
			systemRole.setCreateTime(LocalDateTime.now());
			insertSystemRole(systemRole);
			id = systemRole.getId();
		} else {
			systemRolePermissionMapper.deleteSystemRolePermissionByRoleId(id);
			updateSystemRole(systemRole);
		}
		systemRolePermissionMapper.batchInsertSystemRolePermission(getSystemRolePermissions(permissionIds, id));
	}

	@Override
	public RoleVO getDetail(Long roleId) {
		RoleVO roleVO = new RoleVO();
		roleVO.setSystemRole(selectSystemRoleById(roleId));
		roleVO.setPermissionTree(systemPermissionService.getPermissionTreeById(roleId));
		return roleVO;
	}

	@Override
	public List<SystemRole> selectSystemRoleListAll() {
		return systemRoleMapper.selectSystemRoleListAll();
	}

	@Override
	public int updateStatus(Long roleId, int freeze) {
		if (freeze == SystemRoleStatusConstant.FREEZE) {
			Integer result = systemUserRoleMapper.checkSystemRoleByRoleId(roleId);
			if (Objects.nonNull(result)) {
				throw new PrivateException(ErrorInfoEnum.REMOVE_ROLE_USER);
			}
		}
		int count = systemRoleMapper.updateStatus(roleId, freeze);
		if (count != 1) {
			throw new PrivateException(ErrorInfoEnum.UPDATE_ERROR);
		}
		return count;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Long roleId) {
		SystemRole systemRole = systemRoleMapper.selectSystemRoleById(roleId);
		if (systemRole.getStatus() == SystemRoleStatusConstant.UNFREEZE) {
			throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
		}
		systemRoleMapper.deleteSystemRoleById(roleId);
		systemRolePermissionMapper.deleteSystemRolePermissionByRoleId(roleId);
	}

	private void checkUsernameByUserId(String name, Long roleId) {
		Integer isSameRoleName = systemRoleMapper.checkRoleNoStateById(name, roleId);
		if (Objects.nonNull(isSameRoleName)) {
			throw new PrivateException(ErrorInfoEnum.ROLE_NAME_SAME);
		}
	}

	private void checkPermissionIds(List<Long> permissionIds) {
		int count = systemPermissionMapper.checkId(permissionIds);
		if (count != permissionIds.size()) {
			throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
		}
	}

	/**
	 *
	 * @param permissionIds
	 * @param userId
	 * @return
	 */
	private List<SystemRolePermission> getSystemRolePermissions(List<Long> permissionIds, Long userId) {
		List<SystemRolePermission> list = new ArrayList<>(permissionIds.size());
		LocalDateTime now = LocalDateTime.now();
		permissionIds.stream().forEach(permissionId -> {
			SystemRolePermission systemRolePermission = new SystemRolePermission();
			systemRolePermission.setCreateTime(now);
			systemRolePermission.setPermissionId(permissionId);
			systemRolePermission.setRoleId(userId);
			list.add(systemRolePermission);
		});
		return list;
	}

}
