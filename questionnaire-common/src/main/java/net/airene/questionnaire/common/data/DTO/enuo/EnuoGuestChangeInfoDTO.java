package net.airene.questionnaire.common.data.DTO.enuo;

import lombok.Data;

import java.io.Serializable;

/**
 * 一诺365换房旅客信息
 */
@Data
public class EnuoGuestChangeInfoDTO implements Serializable {

    /**
     * 旅馆编码
     */
    private String LVBM;

    /**
     * 房间编码
     */
    private String FJBM;

    /**
     * 更换后房间编码
     */
    private String FJBMD;

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

}
