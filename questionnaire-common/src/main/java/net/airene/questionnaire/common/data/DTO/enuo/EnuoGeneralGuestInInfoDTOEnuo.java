package net.airene.questionnaire.common.data.DTO.enuo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 一诺365境内旅客入住信息
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EnuoGeneralGuestInInfoDTOEnuo extends EnuoBaseGuestInInfoDTO implements Serializable {

    public EnuoGeneralGuestInInfoDTOEnuo() {
        super(0);
    }
    /**
     * 证件种类
     */
    private String ZJZL;

    /**
     * 姓名
     */
    private String XM;

    /**
     * 民族
     */
    private String MZ;

    /**
     * 省市县
     */
    private String SSX;

    /**
     * 详细地址
     */
    private String XXDZ;
}
