package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 可住房间
 * @date 2021年05月27日 18:09
 */
@Data
public class LvPMSRoomableRoomResponseDTO {
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
     * 房间状态(见E00)
     */
    private String C03;

    /**
     * 房型PMS编码
     */
    private String C04;

    /**
     * 附加信息(1-否,2-是)
     */
    private String C05;
}
