package net.airene.questionnaire.common.data.DTO.userCenter;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 注册用户信息
 * @date 2021年08月30日 17:25
 */
@Data
@ToString(callSuper = true)
public class UserRegistRequestDTO extends BaseRequestDTO implements Serializable {

    // 电话号码（必须）
    private String phone;

    // 验证码（必须）
    private String smsCode;

}
