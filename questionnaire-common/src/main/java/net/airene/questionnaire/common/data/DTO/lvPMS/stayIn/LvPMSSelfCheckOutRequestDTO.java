package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 自助结账DTO
 * @date 2021年05月27日 19:23
 */
@Data
public class LvPMSSelfCheckOutRequestDTO {
    /**
     * 自助厂家标识代码
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
     * 入住单PMS编码;(多个用|隔开)
     */
    private String Q03;

    /**
     * 是否退房(1-是,2-否, 5-挂账i-s)
     */
    private String Q04;

    /**
     * 支付信息(支付金额为负数时,表示退款)
     */
    private String Q05;

    /**
     * 预留
     */
    private String Q06;

    /**
     * 班别PMS编码;(1-早班,2-中班,3-晚班,4-夜审)
     */
    private String Q07;

    /**
     * 设备人工编号
     */
    private String Q08;

    /**
     * 预留
     */
    private String Q09;
}
