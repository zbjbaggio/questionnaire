package net.airene.questionnaire.common.data.DTO.userCenter;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 用户注册
 * @date 2021/9/8
 */
@Data
public class UserRegistDTO implements Serializable {

    // 电话号码（必须）
    private String phone;

    // 渠道号（必须）
    private String channelId;

    // 验证码（必须）
    private String code;

    // 来源（必须） allinone是一体机
    private String resource;
}
