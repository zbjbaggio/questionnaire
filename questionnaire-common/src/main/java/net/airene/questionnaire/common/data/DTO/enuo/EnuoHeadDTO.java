package net.airene.questionnaire.common.data.DTO.enuo;

import lombok.Data;

import java.io.Serializable;

/**
 * 一诺365 head
 */
@Data
public class EnuoHeadDTO implements Serializable {

    /**
     * 业务编码
     */
    private String BUSCODE;

    /**
     * 交易动作代码
     * 0：请求1：应答
     */
    private String ACTIONCODE;

    /**
     * 回复代码
     * ACTIONCODE=1时有回复代码
     */
    private String REPLYCODE;

    /**
     * 提示信息
     */
    private String MESSAGE;

    /**
     * 压缩标识
     * 0:不压缩；1:压缩
     */
    private String ZIPCODE;
}
