package net.airene.questionnaire.common.data.DTO.system;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户角色表 t_system_user_role
 *
 * @author eason
 * @date 2020-03-06
 */
@Data
public class SystemRoleUserDTO {

	/** 用户id */
	private List<Long> userIds;

	/** 角色id */
	@NotNull
	private Long roleId;

}
