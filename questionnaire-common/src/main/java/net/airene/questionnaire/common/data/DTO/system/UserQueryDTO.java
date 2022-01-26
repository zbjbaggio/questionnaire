package net.airene.questionnaire.common.data.DTO.system;

import net.airene.questionnaire.common.data.entity.system.SystemUser;
import lombok.Data;

@Data
public class UserQueryDTO extends SystemUser {

    private Long roleId;

}
