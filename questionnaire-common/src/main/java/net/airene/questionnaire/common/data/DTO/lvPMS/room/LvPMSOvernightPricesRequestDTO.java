package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询过夜房价DTO
 * @date 2021年05月27日 18:23
 */
@Data
public class LvPMSOvernightPricesRequestDTO {
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
     * 开始日期
     */
    private String Q03;

    /**
     * 结束日期
     */
    private String Q04;

    /**
     * 房型PMS编码
     */
    private String Q05;

    /**
     * PMS房价码
     */
    private String Q11;
}
