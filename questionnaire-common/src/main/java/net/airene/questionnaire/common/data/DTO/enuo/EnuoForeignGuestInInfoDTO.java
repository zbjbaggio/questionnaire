package net.airene.questionnaire.common.data.DTO.enuo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 一诺365境外旅客入住信息
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EnuoForeignGuestInInfoDTO extends EnuoBaseGuestInInfoDTO implements Serializable {

    private static final int SING = 1;

    public EnuoForeignGuestInInfoDTO() {
        super(SING);
    }

    /**
     * 中文名
     */
    private String ZWM;

    /**
     * 国籍地区
     */
    private String GJDQ;

    /**
     * 证件类型
     */
    private String ZJLX;

    /**
     * 英文姓
     */
    private String YWX;

    /**
     * 英文名
     */
    private String YWM;

    /**
     * 签发机关
     */
    private String QFJG;

    /**
     * 签证种类
     */
    private String QZZL;

    /**
     * 签证号码
     */
    private String QZHM;

    /**
     * 在华停留至
     */
    private String TLRQ;

    /**
     * 入境日期
     */
    private String RJRQ;

    /**
     * 入境口岸
     */
    private String RJKA;

    /**
     * 证件有效期
     */
    private String ZJYXQ;

    /**
     * 接待单位
     */
    private String JDDW;

    /**
     * 接待人
     */
    private String JDR;

    /**
     * 从何地来
     */
    private String CHDL;

    /**
     * 到何地去
     */
    private String DHDQ;

    /**
     * 停留事由
     */
    private String TLSY;

    /**
     * 职业
     */
    private String ZY;

    /**
     * 出生地
     */
    private String CSD;

    /**
     * 血统
     */
    private String XT;

    /**
     * 邀请人
     */
    private String YQR;

    /**
     * 拟离开日期
     */
    private String NLKRQ;

    /**
     * 备注
     */
    private String BZ;
}
