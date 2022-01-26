package net.airene.questionnaire.common.data.DTO.system;

import net.airene.questionnaire.common.data.entity.system.SystemRole;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class SystemRoleDTO extends SystemRole {

	/** 创建人名称 */
	private String creatorName;

}
