package net.airene.questionnaire.common.data.entity.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import net.airene.questionnaire.common.constant.system.SystemUserStatusConstant;
import net.airene.questionnaire.common.data.DTO.system.SystemUserRoleDTO;
import net.airene.questionnaire.common.data.entity.BaseEntity;

import javax.validation.constraints.NotEmpty;

/**
 * 系统用户表 t_system_user
 *
 * @author eason
 * @date 2020-03-06
 */
@Data
@ToString(callSuper = true)
public class SystemUser extends BaseEntity {

	/** 用户登录名 */
	@NotEmpty(groups = {SystemUserRoleDTO.Save.class})
	private String username;

	/**
	 * 手机号
	 */
	@NotEmpty(groups = {SystemUserRoleDTO.Save.class})
	private String phone;

	/**
	 * 真实姓名
	 */
	@NotEmpty(groups = {SystemUserRoleDTO.Save.class})
	private String realName;

	/**
	 * 公司
	 */
	@NotEmpty(groups = {SystemUserRoleDTO.Save.class})
	private String company;

	/**
	 * 部门
	 */
	@NotEmpty(groups = {SystemUserRoleDTO.Save.class})
	private String department;

	/** 密码 */
	//@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	/** md5密码盐 */
	@JsonIgnore
	private String salt;

	/**
	 * 状态(1-正常,0-冻结)
	 * {@link SystemUserStatusConstant}
	 * */
	private Integer status;

}
