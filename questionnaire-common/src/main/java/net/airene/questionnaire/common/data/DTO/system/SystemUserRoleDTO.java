package net.airene.questionnaire.common.data.DTO.system;

import net.airene.questionnaire.common.data.entity.system.SystemUser;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SystemUserRoleDTO {

	/**
	 * 用户信息
	 */
	@Valid
	@NotNull(groups = {Save.class})
	private SystemUser systemUser;

	/**
	 * 角色id
	 * {@link net.airene.questionnaire.common.data.entity.system.SystemRole.id}
	 */
	@NotNull(groups = {Save.class})
	@Size(min = 1, groups = {Save.class})
	private List<Long> roleIds;

	public interface Save {

	}

}
