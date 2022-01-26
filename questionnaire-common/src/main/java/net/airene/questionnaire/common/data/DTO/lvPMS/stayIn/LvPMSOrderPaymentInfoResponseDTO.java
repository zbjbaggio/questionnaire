package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 主单付款情况
 * @date 2021年05月28日 10:11
 */
@Data
public class LvPMSOrderPaymentInfoResponseDTO {
    /**
     * 应支付金额
     */
    private String C00;

    /**
     * 总房费
     */
    private String C01;

    /**
     * 预付款
     */
    private String C02;

    /**
     * 主预订单PMS编码
     */
    private String C03;

    /**
     * 预留
     */
    private String C04;
}
