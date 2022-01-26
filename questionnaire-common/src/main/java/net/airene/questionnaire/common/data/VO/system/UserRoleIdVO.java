package net.airene.questionnaire.common.data.VO.system;

import lombok.Data;
import lombok.ToString;
import net.airene.questionnaire.common.data.entity.system.SystemUser;

@Data
@ToString(callSuper = true)
public class UserRoleIdVO extends SystemUser {

    private Long roleId;

}
