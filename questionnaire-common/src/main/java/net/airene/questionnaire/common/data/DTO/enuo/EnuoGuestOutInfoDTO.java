package net.airene.questionnaire.common.data.DTO.enuo;

import lombok.Data;

import java.io.Serializable;

/**
 * 一诺365退房旅客信息
 */
@Data
public class EnuoGuestOutInfoDTO implements Serializable {

    /**
     * 旅馆编码
     */
    private String LVBM;

    /**
     * 房间编码
     */
    private String FJBM;

    /**
     * 是否境内人员
     */
    private String SFJN;

    /**
     * 证件种类
     */
    private String ZJZL;

    /**
     * 证件号码
     */
    private String ZJHM;

    /**
     * 退房时间
     */
    private String TFSJ;

}
