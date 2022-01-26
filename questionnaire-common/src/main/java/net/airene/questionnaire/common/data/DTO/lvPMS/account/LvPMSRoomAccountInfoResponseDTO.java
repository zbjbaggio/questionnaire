package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 客房账单
 * @date 2021年05月28日 10:38
 */
@Data
public class LvPMSRoomAccountInfoResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 账目记录PMS编码
     */
    private String C01;

    /**
     * 房号
     */
    private String C02;

    /**
     * 账目类别PMS编码
     */
    private String C03;

    /**
     * 账目名称
     */
    private String C04;

    /**
     * 账目类别;(消费项目用1,银行卡预授权用21,其它支付项目用22)
     */
    private String C05;

    /**
     * 数量(十六进制数)
     */
    private String C06;

    /**
     * 金额
     */
    private String C07;

    /**
     * 时间
     */
    private String C08;

    /**
     * 账目代码
     */
    private String C09;

    /**
     * 备注
     */
    private String C10;

    /**
     * 预留;支付交易参数
     */
    private String C11;

    /**
     * PMS费用码/付款编码
     */
    private String C12;
}
