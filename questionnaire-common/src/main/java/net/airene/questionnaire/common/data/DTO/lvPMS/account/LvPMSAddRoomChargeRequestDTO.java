package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 加收房费请求DTO
 * @date 2021年05月28日 10:48
 */
@Data
public class LvPMSAddRoomChargeRequestDTO {
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
     * 入住单PMS编码#房费类型#加收金额
     */
    private String Q03;

    /**
     * 工号PMS编码
     */
    private String Q04;

    /**
     * 班别PMS编码;(1-早班,2-中班,3-晚班,4-夜审)
     */
    private String Q05;

    /**
     * 设备人工编号(存储于账务摘要,以便区分入账客户端)
     */
    private String Q06;

    /**
     * 房费类型(0-不限,1-全天房费,2-半天房费)
     */
    private String E58;
}
