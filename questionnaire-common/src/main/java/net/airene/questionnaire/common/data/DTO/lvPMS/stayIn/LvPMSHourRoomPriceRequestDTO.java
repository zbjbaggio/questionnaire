package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询钟点房房价DTO
 * @date 2021年05月28日 10:22
 */
@Data
public class LvPMSHourRoomPriceRequestDTO {
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
     * 房价代码(不传值查询所有)
     */
    private String Q03;

    /**
     * 房型代码(不传值查询所有)
     */
    private String Q04;
}
