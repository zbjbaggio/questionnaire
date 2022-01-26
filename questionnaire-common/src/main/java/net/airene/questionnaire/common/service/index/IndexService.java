package net.airene.questionnaire.common.service.index;

import net.airene.questionnaire.common.data.DTO.captcha.CaptchaDTO;

import java.io.IOException;

/**
 * @author LiPang
 * @Desc 验证码服务层
 * @date 2021年08月30日 19:30
 */
public interface IndexService {

    CaptchaDTO getCaptcha() throws IOException;
}
