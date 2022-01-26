package net.airene.questionnaire.common.service.system;

import net.airene.questionnaire.common.data.DTO.system.SystemRoleDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemRolePermissionDTO;
import net.airene.questionnaire.common.data.VO.system.RoleVO;
import net.airene.questionnaire.common.data.entity.system.SystemRole;

import java.util.List;

/**
 * 角色 服务层
 *
 * @author eason
 * @date 2020-03-06
 */
public interface SystemRoleService {
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
     * @param systemRole 角色信息
     * @return 角色集合
     */
	List<SystemRoleDTO> selectSystemRoleList(SystemRoleDTO systemRoleDTO);

	/**
     * 新增角色
     *
     * @param systemRole 角色信息
     * @return 结果
     */
	SystemRole insertSystemRole(SystemRole systemRole);

	/**
     * 修改角色
     *
     * @param systemRole 角色信息
     * @return 结果
     */
	int updateSystemRole(SystemRole systemRole);

	/**
     * 删除角色信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSystemRoleByIds(Long[] ids);

    void save(SystemRolePermissionDTO systemRolePermissionDTO);

	RoleVO getDetail(Long roleId);

    List<SystemRole> selectSystemRoleListAll();

	int updateStatus(Long roleId, int freeze);

    void delete(Long roleId);
}
