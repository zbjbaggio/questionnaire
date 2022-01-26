package net.airene.questionnaire.common.data.DTO.userCenter;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 获取验证码
 * @date 2021年08月30日 14:39
 */
@Data
@ToString(callSuper = true)
public class SendCodeRequestDTO extends BaseRequestDTO implements Serializable {

    // 图形验证码
    private String captcha;

    private String checkCode;

    // 电话号码（必须）
    private String phone;

    // 渠道号（必须）
    private String channelId;

    // 通道类型（必须，短信：1，语音：2）
    private String channelType;

    // 业务选择号（必须，注册:1,登录:2,找回登陆密码：3,找回支付密码：4,更换手机号码：5）
    private String templateId;

    // 版本号，取值=1.1，仅限此次修改手机号给老号码发送验证码时使用（非必须）
    private String version;

}
