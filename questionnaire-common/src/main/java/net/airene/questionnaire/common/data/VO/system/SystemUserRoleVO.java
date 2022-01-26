package net.airene.questionnaire.common.data.VO.system;

import lombok.Data;
import net.airene.questionnaire.common.data.entity.system.SystemUser;

import java.util.List;

@Data
public class SystemUserRoleVO {

    private SystemUser systemUser;

    private List<Long> roleId;

}
