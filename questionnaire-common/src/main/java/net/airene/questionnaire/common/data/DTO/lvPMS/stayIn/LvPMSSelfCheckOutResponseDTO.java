package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 自助结账
 * @date 2021年05月27日 19:25
 */
@Data
public class LvPMSSelfCheckOutResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 结账结果(1-成功,2-失败)
     */
    private String C01;

    /**
     * 结账结果说明
     */
    private String C02;

    /**
     * 自助设备的交易记录编码#支付记录PMS编码
     */
    private String C03;
}
