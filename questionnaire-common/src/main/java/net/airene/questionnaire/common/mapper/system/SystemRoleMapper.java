package net.airene.questionnaire.common.mapper.system;

import net.airene.questionnaire.common.data.DTO.system.SystemRoleDTO;
import net.airene.questionnaire.common.data.entity.system.SystemRole;

import java.util.List;

/**
 * 角色 数据层
 *
 * @author eason
 * @date 2020-03-06
 */
public interface SystemRoleMapper {
	/**
     * 查询角色信息
     *
     * @param id 角色ID
     * @return 角色信息
     */
	SystemRole selectSystemRoleById(Long id);

	/**
     * 查询角色列表
     *
     * @param systemRoleDTO 角色信息
     * @return 角色集合
     */
	List<SystemRoleDTO> selectSystemRoleList(SystemRoleDTO systemRoleDTO);

	/**
     * 新增角色
     *
     * @param systemRole 角色信息
     * @return 结果
     */
	int insertSystemRole(SystemRole systemRole);

	/**
     * 修改角色
     *
     * @param systemRole 角色信息
     * @return 结果
     */
	int updateSystemRole(SystemRole systemRole);

	/**
     * 删除角色
     *
     * @param id 角色ID
     * @return 结果
     */
	int deleteSystemRoleById(Long id);

	/**
     * 批量删除角色
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSystemRoleByIds(Long[] ids);

	/**
	 * 检查角色id是否存在
	 * @param roleIds
	 * @return
	 */
    int checkId(List<Long> roleIds);

	/**
	 * 查询所有未冻结角色
	 * @return
	 */
	List<SystemRole> selectSystemRoleListAll();

	/**
	 * 检查角色名称是否重复
	 * @param name
	 * @param roleId
	 * @return
	 */
	Integer checkRoleNoStateById(String name, Long roleId);

	/**
	 * 修改状态
	 * @param roleId
	 * @param status
	 * @return
	 */
	int updateStatus(Long roleId, int status);

}
