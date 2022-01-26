package net.airene.questionnaire.common.service.impl.index;

import net.airene.questionnaire.common.data.DTO.captcha.CaptchaDTO;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.service.index.IndexService;
import net.airene.questionnaire.common.util.CaptchaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author LiPang
 * @Desc 验证码服务层
 * @date 2021年08月30日 19:31
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class IndexServiceImpl implements IndexService {

    private final RedisService redisService;

    /**
     * 获取图形验证码
     * @return
     */
    @Override
    public CaptchaDTO getCaptcha() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Map<String, Object> map = CaptchaUtil.getImageCode(86, 37, baos);
        ImageIO.write((BufferedImage) map.get("image"), "jpg", baos);
        byte[] bytes = baos.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
        baos.close();
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        String captchaStr = UUID.randomUUID().toString();
        CaptchaDTO captcha = new CaptchaDTO();
        captcha.setCaptcha(captchaStr);
        captcha.setCheckCode("data:image/jpeg;base64," + png_base64);
        redisService.saveCaptcha(captchaStr, map.get("strEnsure").toString().toLowerCase());
        return captcha;
    }
}
