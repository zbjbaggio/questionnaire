package net.airene.questionnaire.common.service.system;

import net.airene.questionnaire.common.data.DTO.system.SystemRoleUserDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemUserDTO;
import net.airene.questionnaire.common.data.DTO.system.SystemUserRoleDTO;
import net.airene.questionnaire.common.data.DTO.system.UserQueryDTO;
import net.airene.questionnaire.common.data.VO.system.SystemUserRoleVO;
import net.airene.questionnaire.common.data.VO.system.SystemUserVO;
import net.airene.questionnaire.common.data.VO.system.UserRoleIdVO;
import net.airene.questionnaire.common.data.entity.system.SystemUser;

import java.util.List;
import java.util.Set;

/**
 * 系统用户 服务层
 *
 * @author eason
 * @date 2020-03-06
 */
public interface SystemUserService {
	/**
     * 查询系统用户信息
     *
     * @param id 系统用户ID
     * @return 系统用户信息
     */
	SystemUserRoleVO selectSystemUserById(Long id);

	/**
     * 查询系统用户列表
     *
     * @param systemUser 系统用户信息
     * @return 系统用户集合
     */
	List<SystemUser> selectSystemUserList(SystemUser systemUser);

	/**
     * 新增系统用户
     *
     * @param systemUser 系统用户信息
     * @return 结果
     */
	SystemUser insertSystemUser(SystemUser systemUser);

	/**
     * 修改系统用户
     *
     * @param systemUser 系统用户信息
     * @return 结果
     */
	int updateSystemUser(SystemUser systemUser);

	/**
     * 删除系统用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSystemUserByIds(Long[] ids);

	SystemUserVO login(SystemUserDTO systemUserDTO);

    Set<String> listPermissionsByUserId(Long userId);

	void updateStatus(Long userId, int freeze);

    void save(SystemUserRoleDTO systemUserRoleDTO);

    List<SystemUser> listHasUserList(Long roleId);

	List<UserRoleIdVO> selectSystemUserAllList(UserQueryDTO userQueryDTO);

	void saveUsers(SystemRoleUserDTO systemRoleUserDTO);
}
