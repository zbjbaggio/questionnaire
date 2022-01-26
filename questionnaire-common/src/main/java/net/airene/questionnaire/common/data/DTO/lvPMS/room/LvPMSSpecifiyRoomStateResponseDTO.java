package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 指定房态
 * @date 2021年05月27日 18:04
 */
@Data
public class LvPMSSpecifiyRoomStateResponseDTO {
    /**
     * 房号
     */
    private String C00;

    /**
     * 业务日期
     */
    private String C01;

    /**
     * 房间状态
     */
    private String C02;

    /**
     * 预订单PMS编码
     */
    private String C03;

    /**
     * 是否本日将离(1-否,2-是)
     */
    private String C04;

    /**
     * 是否本日将到(1-否,2-是)
     */
    private String C05;
}
