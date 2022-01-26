package net.airene.questionnaire.common.data.DTO.captcha;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 验证码类
 * @date 2021年08月30日 19:33
 */
@Data
public class CaptchaDTO {

    private String captcha;

    private String checkCode;
}
