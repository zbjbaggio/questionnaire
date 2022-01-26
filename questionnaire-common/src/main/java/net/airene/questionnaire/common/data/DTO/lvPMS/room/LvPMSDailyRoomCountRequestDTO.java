package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询每日房量DTO
 * @date 2021年05月27日 17:27
 */
@Data
public class LvPMSDailyRoomCountRequestDTO {
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
     * 开始日期(大于等于)
     */
    private String Q03;

    /**
     * 结束日期(小于等于)
     */
    private String Q04;

    /**
     * 房型PMS编码
     */
    private String Q05;
}
