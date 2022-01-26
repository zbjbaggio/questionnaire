package net.airene.questionnaire.common.data.DTO;

import net.airene.questionnaire.common.data.VO.VersionResponseVO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginDTO implements Serializable {

    private String token;

    private VersionResponseVO version;

}
