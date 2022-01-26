package net.airene.questionnaire.common.mapper.system;

import net.airene.questionnaire.common.data.DTO.system.UserQueryDTO;
import net.airene.questionnaire.common.data.VO.system.UserRoleIdVO;
import net.airene.questionnaire.common.data.entity.system.SystemUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

/**
 * 系统用户 数据层
 *
 * @author eason
 * @date 2020-03-06
 */
@Mapper
public interface SystemUserMapper {
	/**
     * 查询系统用户信息
     *
     * @param id 系统用户ID
     * @return 系统用户信息
     */
	SystemUser selectSystemUserById(Long id);

	/**
	 * 查询系统用户信息
	 * @param ids
	 * @return
	 */
	List<SystemUser> selectSystemUserByIds(Set<Long> ids);

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
	int insertSystemUser(SystemUser systemUser);

	/**
     * 修改系统用户
     *
     * @param systemUser 系统用户信息
     * @return 结果
     */
	int updateSystemUser(SystemUser systemUser);

	/**
     * 删除系统用户
     *
     * @param id 系统用户ID
     * @return 结果
     */
	int deleteSystemUserById(Long id);

	/**
     * 批量删除系统用户
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSystemUserByIds(Long[] ids);

	/**
	 * 根据用户名查询正常用户的相关数据
	 * @param username
	 * @return
	 */
    SystemUser getByUsername(String username);

	/**
	 * 根据用户id查询该用户拥有的权限
	 * @param userId
	 * @return 后端权限url
	 */
	Set<String> selectPermissionByUserId(Long userId);

    Integer checkUserInfoNoStateNoId(String username, Long id);

	int updateStatusById(Long userId, int status);

    List<SystemUser> selectHasUserList(Long roleId);

	List<UserRoleIdVO> selectSystemUserAllList(UserQueryDTO userQueryDTO);

	int countSystemUserByIds(List<Long> userIds);

    SystemUser getLikeUsername(String creator);
}
