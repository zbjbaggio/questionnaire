package net.airene.questionnaire.common.data.DTO.system;

import net.airene.questionnaire.common.data.entity.system.SystemRole;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SystemRolePermissionDTO {

    /**
     * 角色
     */
    @Valid
    @NotNull(groups = {Save.class})
    private SystemRole systemRole;

    /**
     * 权限id
     * {@link SystemPermission.id}
     */
    @NotNull(groups = {Save.class})
    @Size(min = 1, groups = {Save.class})
    private List<Long> permissionIds;

    public interface Save {

    }

}
