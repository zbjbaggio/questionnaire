package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询入住单房价DTO
 * @date 2021年05月28日 10:42
 */
@Data
public class LvPMSStayInOrderPriceRequestDTO {
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
     * 入住日期
     */
    private String Q04;
}
