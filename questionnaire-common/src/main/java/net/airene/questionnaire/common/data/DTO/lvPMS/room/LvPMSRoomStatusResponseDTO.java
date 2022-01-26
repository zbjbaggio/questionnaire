package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 所有房态
 * @date 2021年05月27日 18:20
 */
@Data
public class LvPMSRoomStatusResponseDTO {
    /**
     * 楼宇PMS编码
     */
    private String C00;

    /**
     * 楼层PMS编码
     */
    private String C01;

    /**
     * 房号PMS编码
     */
    private String C02;

    /**
     * 房间状态
     */
    private String C03;

    /**
     * 房型PMS编码
     */
    private String C04;

    /**
     * 是否本日将离(1-否,2-是)
     */
    private String C05;

    /**
     * 房间状态
     */
    private String C06;

    /**
     *
     */
    private String C07;
}
