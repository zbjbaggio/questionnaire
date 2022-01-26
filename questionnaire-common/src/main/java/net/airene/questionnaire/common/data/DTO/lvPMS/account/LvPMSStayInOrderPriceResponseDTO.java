package net.airene.questionnaire.common.data.DTO.lvPMS.account;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 入住单房价
 * @date 2021年05月28日 10:42
 */
@Data
public class LvPMSStayInOrderPriceResponseDTO {
    /**
     * 入住日期
     * 格式:yyyy-MM-dd
     */
    private String C00;

    /**
     * 房价
     */
    private String C01;

    /**
     * 入住单PMS编码
     */
    private String C02;
}
