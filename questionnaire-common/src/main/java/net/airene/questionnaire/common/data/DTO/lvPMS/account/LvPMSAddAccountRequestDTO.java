package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 添加账务请求DTO
 * @date 2021年05月28日 10:33
 */
@Data
public class LvPMSAddAccountRequestDTO {
    /**
     * 预留
     */
    private String Q00;

    /**
     * 预留
     */
    private String Q01;

    /**
     * 酒店PMS编码
     */
    private String Q02;

    /**
     * 入住单PMS编码
     */
    private String Q03;

    /**
     * 消费项目:入账PMS编码#总金额#数量#账目类别#操作时间;
     */
    private String Q04;

    /**
     * PMS工号
     */
    private String Q05;

    /**
     * 班别PMS编码;(1-早班,2-中班,3-晚班,4-夜审)
     */
    private String Q06;

    /**
     * Q支付类型#支付方式#支付金额#自助设备支付记录编码#
     * 交易流水号#工号PMS编码#操作时间#交易类型#卡号#有效期#
     */
    private String Q07;

    /**
     * 账务备注
     */
    private String Q08;
}
