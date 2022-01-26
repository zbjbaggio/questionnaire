package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 入住
 * @date 2021年05月27日 18:47
 */
@Data
public class LvPMSStayInResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 自助设备的的支付记录编码#支付记录PMS编码
     */
    private String C01;

    /**
     * 客人证件号#客人入住流水号
     */
    private String C02;
}
