package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询可住房间DTO
 * @date 2021年05月27日 18:06
 */
@Data
public class LvPMSRoomableRoomRequestDTO {
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
     * 房型PMS编码
     */
    private String Q03;

    /**
     * 入住日期
     */
    private String Q04;

    /**
     * 离店日期
     */
    private String Q05;

    /**
     * 楼宇PMS编码
     */
    private String Q06;

    /**
     * 楼层PMS编码
     */
    private String Q07;

    /**
     * 是否包含脏房(1-是,2-否)(空时默认否)
     */
    private String Q08;

    /**
     * 是否包含维修房(1-是,2-否)(空时默认否)
     */
    private String Q09;

    /**
     * 是否包含临时不可用房(1-是,2-否);(空时默认否)
     */
    private String Q10;

    /**
     * 排除房号
     */
    private String Q12;
}
