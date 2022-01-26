package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc PMS酒店详情
 * @date 2021年05月28日 11:23
 */
@Data
public class LvPMSHotelInfoResponseDTO {
    /**
     * 所属品牌PMS编码
     */
    private String C00;

    /**
     * 酒店名称
     */
    private String C01;

    /**
     * 酒店PMS编码
     */
    private String C02;

    /**
     * 电话
     */
    private String C03;

    /**
     * 地址
     */
    private String C04;
}
