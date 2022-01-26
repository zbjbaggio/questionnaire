package net.airene.questionnaire.common.data.DTO.system;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SystemUserDTO {

    @NotEmpty(groups = LoginGroup.class)
    private String username;

    @NotEmpty(groups = LoginGroup.class)
    private String password;

    @NotEmpty(groups = LoginGroup.class)
    private String token;

    @NotEmpty(groups = LoginGroup.class)
    private String captcha;

    public interface LoginGroup {

    }

}
