package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 每日房量
 * (1)当日在住过夜房数=(过夜房)上日过夜房数-(过夜房)当日将离房数;
 * (2)可用房数(含脏房)=该房型的总房间数-当日在住过夜房数-当日将到房数(预订单)
 * -当日夜间维修房数-当日夜间临时不可用房数。(=空房+维修房+临时房);
 * @date 2021年05月27日 17:29
 */
@Data
public class LvPMSDailyRoomCountResponseDTO {
    /**
     * 房型PMS编码
     */
    private String C00;

    /**
     * 日期
     * yyyy-MM-dd HH:mm:ss
     */
    private String C01;

    /**
     * 该房型的总房间数
     */
    private Integer C02;

    /**
     * 当日在住过夜房数
     */
    private Integer C03;

    /**
     * 当日将到房数(全部)
     */
    private Integer C04;

    /**
     * 当日将离房数(全部)
     */
    private Integer C05;

    /**
     * 当日夜间维修房数
     */
    private Integer C06;

    /**
     * 当日夜间临时不可用房数
     */
    private Integer C07;
}
