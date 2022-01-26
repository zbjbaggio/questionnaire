package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询客房账单DTO
 * @date 2021年05月28日 10:36
 */
@Data
public class LvPMSRoomAccountInfoRequestDTO {
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
     * 查询值类型(1-入住单PMS编码)
     */
    private String Q03;

    /**
     * 查询值(多个用|隔开)
     */
    private String Q04;

    /**
     * 账目类别
     */
    private String Q05;

    /**
     * 结账状态
     */
    private String Q06;
}
