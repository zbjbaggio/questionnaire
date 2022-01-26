package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 房价码查询DTO
 * @date 2021年05月27日 18:27
 */
@Data
public class LvPMSPricesCodeRequestDTO {
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
     * 房价码类别(R -散客类 M-会员类,G-团队类,C-协议公司类)
     */
    private String Q03;
}
