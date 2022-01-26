package net.airene.questionnaire.common.data.DTO.userCenter;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 用户中心返回信息
 * @date 2021年08月30日 11:22
 */
@Data
public class UserCenterReturnMsg implements Serializable {

    private Integer code;

    private String msg;

    private Object data;
}
