package net.airene.questionnaire.admin.controller.advice;

import com.google.code.kaptcha.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.admin.data.vo.CatpchaVO;
import net.airene.questionnaire.common.data.DTO.system.SystemUserDTO;
import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.data.VO.system.SystemUserVO;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.service.system.SystemUserService;
import net.airene.questionnaire.common.util.JwtUtil;
import net.airene.questionnaire.common.util.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LoginController {

    private final SystemUserService systemUserService;

    private final Producer captchaProducer;

    private final RedisService redisService;

    private final JwtUtil jwtUtil;

    @GetMapping(value = "/captcha")
    public CatpchaVO captcha() throws IOException {
        // 生成验证码
        CatpchaVO catpchaVO = new CatpchaVO();
        catpchaVO.setToken(jwtUtil.sign(null));
        String text = captchaProducer.createText();
        redisService.saveCaptcha(catpchaVO.getToken(), text);
        BufferedImage image = captchaProducer.createImage(text);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            String png_base64 = new String(Base64.encodeBase64(bytes));
            png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
            catpchaVO.setCaptcha("data:image/jpeg;base64," + png_base64);
        } catch (IOException e) {
            log.error("响应验证码失败:" + e.getMessage());
        }
        finally {
            baos.close();
        }
        return catpchaVO;
    }

    /**
     * 登录接口
     *
     * @param systemUserDTO
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public SystemUserVO login(@RequestBody @Validated(SystemUserDTO.LoginGroup.class) SystemUserDTO systemUserDTO) {
        // 校验验证码
        String token = systemUserDTO.getToken();
        if (!jwtUtil.verify(token)) {
            log.error("token解析失败！");
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }
        String captcha = redisService.getCaptcha(token);
        redisService.deleteCaptcha(token);
        if (StringUtils.isEmpty(captcha)) {
            throw new PrivateException(ErrorInfoEnum.CODE_TIME_OUT);
        } else if (!captcha.equals(systemUserDTO.getCaptcha())) {
            throw new PrivateException(ErrorInfoEnum.CODE_ERROR);
        }
        return systemUserService.login(systemUserDTO);
    }

}
