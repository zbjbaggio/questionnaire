package net.airene.questionnaire.common.data.VO.system;

import lombok.Data;
import net.airene.questionnaire.common.data.entity.system.SystemRole;

import java.util.List;

@Data
public class RoleVO {

    private SystemRole systemRole;

    private List<Long> permissionIds;

    private List<PermissionVO> permissionTree;

}
