package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 过夜房价
 * @date 2021年05月27日 18:25
 */
@Data
public class LvPMSOvernightPricesResponseDTO {
    /**
     * 业务日期
     */
    private String C00;

    /**
     * 房型PMS编码
     */
    private String C01;

    /**
     * 标准过夜房价
     */
    private String C02;

    /**
     * 标准凌晨房价
     */
    private String C03;

    /**
     * 折后过夜房价
     */
    private String C04;

    /**
     * 折后凌晨房价
     */
    private String C05;

    /**
     * PMS房价码
     */
    private String C06;

    /**
     * 价格类别
     */
    private String C07;

    /**
     * 成交价格
     */
    private String C08;
}
