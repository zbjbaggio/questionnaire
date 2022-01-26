package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询所有房态DTO
 * @date 2021年05月27日 18:19
 */
@Data
public class LvPMSRoomStatusRequestDTO {
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
     * 入住日期
     */
    private String Q03;

    /**
     * 离店日期
     */
    private String Q04;

    /**
     * 楼宇PMS编码
     */
    private String Q05;

    /**
     * 楼层PMS编码
     */
    private String Q06;

    /**
     * 房型PMS编码
     */
    private String Q07;
}
