package net.airene.questionnaire.common.service.system;

import net.airene.questionnaire.common.data.entity.system.SystemRolePermission;

import java.util.List;

/**
 * 角色权限 服务层
 *
 * @author eason
 * @date 2020-03-05
 */
public interface SystemRolePermissionService {
	/**
     * 查询角色权限信息
     *
     * @param id 角色权限ID
     * @return 角色权限信息
     */
	SystemRolePermission selectSystemRolePermissionById(Long id);

	/**
     * 查询角色权限列表
     *
     * @param systemRolePermission 角色权限信息
     * @return 角色权限集合
     */
	List<SystemRolePermission> selectSystemRolePermissionList(SystemRolePermission systemRolePermission);

	/**
     * 新增角色权限
     *
     * @param systemRolePermission 角色权限信息
     * @return 结果
     */
	SystemRolePermission insertSystemRolePermission(SystemRolePermission systemRolePermission);

	/**
     * 修改角色权限
     *
     * @param systemRolePermission 角色权限信息
     * @return 结果
     */
	int updateSystemRolePermission(SystemRolePermission systemRolePermission);

	/**
     * 删除角色权限信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSystemRolePermissionByIds(Long[] ids);

}
