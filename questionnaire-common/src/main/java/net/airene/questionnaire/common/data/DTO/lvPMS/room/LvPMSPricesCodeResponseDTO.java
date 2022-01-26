package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 房价码
 * @date 2021年05月27日 18:28
 */
@Data
public class LvPMSPricesCodeResponseDTO {
    /**
     * 房价编码
     */
    private String C00;

    /**
     * 房价编码描述
     */
    private String C01;

    /**
     * 早餐编码
     */
    private String C02;
}
