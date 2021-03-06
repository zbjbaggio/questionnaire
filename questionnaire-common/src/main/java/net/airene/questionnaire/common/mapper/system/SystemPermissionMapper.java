package net.airene.questionnaire.common.mapper.system;

import net.airene.questionnaire.common.data.VO.system.PermissionVO;
import net.airene.questionnaire.common.data.entity.system.SystemPermission;

import java.util.List;

/**
 * 菜单权限 数据层
 *
 * @author eason
 * @date 2020-03-06
 */
public interface SystemPermissionMapper {
	/**
     * 查询菜单权限信息
     *
     * @param ${primaryKey.attrname} 菜单权限ID
     * @return 菜单权限信息
     */
	SystemPermission selectSystemPermissionById(Long id);

	/**
     * 查询菜单权限列表
     *
     * @param systemPermission 菜单权限信息
     * @return 菜单权限集合
     */
	List<SystemPermission> selectSystemPermissionList(SystemPermission systemPermission);

	/**
     * 新增菜单权限
     *
     * @param systemPermission 菜单权限信息
     * @return 结果
     */
	int insertSystemPermission(SystemPermission systemPermission);

	/**
     * 修改菜单权限
     *
     * @param systemPermission 菜单权限信息
     * @return 结果
     */
	int updateSystemPermission(SystemPermission systemPermission);

	/**
	 * 删除菜单权限
	 *
	 * @param ${primaryKey.attrname} 菜单权限ID
	 * @return 结果
	 */
	int deleteSystemPermissionById(Long id);

	/**
	 * 批量删除菜单权限
	 *
	 * @param id 需要删除的数据ID
	 * @return 结果
	 */
	int deleteSystemPermissionByIds(Long[] id);

	List<PermissionVO> listByUserId(Long uerId);

    int checkId(List<Long> permissionIds);

	List<PermissionVO> selectSystemPermissionListAll();

    List<PermissionVO> selectPermissionByRoleId(Long roleId);

}
