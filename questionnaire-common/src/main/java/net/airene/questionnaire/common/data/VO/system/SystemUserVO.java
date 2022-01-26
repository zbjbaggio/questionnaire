package net.airene.questionnaire.common.data.VO.system;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class SystemUserVO extends MenuAndButtonVO{

    private Long id;

    // token
    private String token;

    // 用户名
    private String username;


}
