package net.airene.questionnaire.common.data.entity.system;

import lombok.Data;
import lombok.ToString;
import net.airene.questionnaire.common.data.DTO.system.SystemRolePermissionDTO;
import net.airene.questionnaire.common.data.entity.BaseEntity;

import javax.validation.constraints.NotEmpty;

/**
 * 角色表 t_system_role
 *
 * @author eason
 * @date 2020-03-06
 */
@Data
@ToString(callSuper = true)
public class SystemRole extends BaseEntity {

	/** 角色名称 */
	@NotEmpty(groups = {SystemRolePermissionDTO.Save.class})
	private String name;

	/**
	 * 状态
	 * {@link net.airene.questionnaire.common.constant.system.SystemRoleStatusConstant}
	 */
	private Integer status;

	/**
	 *创建人
	 */
	private Long creatorId;

	/** 描述 */
	private String description;

	public interface Save {
	}

}
