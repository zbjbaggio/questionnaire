package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查订主单付款情况DTO
 * @date 2021年05月28日 10:10
 */
@Data
public class LvPMSOrderPaymentInfoRequestDTO {
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
     * 预订单PMS编码
     */
    private String Q03;

    /**
     * 主预订单PMS编码
     */
    private String Q04;
}
