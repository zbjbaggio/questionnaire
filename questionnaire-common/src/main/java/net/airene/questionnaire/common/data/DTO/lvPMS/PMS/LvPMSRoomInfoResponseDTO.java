package net.airene.questionnaire.common.data.DTO.lvPMS.PMS;

import lombok.Data;

/**
 * @author LiPang
 * @Desc PMS房间信息
 * @date 2021年05月28日 11:30
 */
@Data
public class LvPMSRoomInfoResponseDTO {
    /**
     * 房间PMS编码
     */
    private String C00;

    /**
     * 房号
     */
    private String C01;

    /**
     * 所属房型PMS编码
     */
    private String C02;

    /**
     * 所属楼宇PMS编码
     */
    private String C03;

    /**
     * 所属楼层PMS编码
     */
    private String C04;

    /**
     * 门锁串号
     */
    private String C05;

    /**
     * 公安系统房号
     */
    private String C06;

    /**
     * 门锁设备楼栋
     */
    private String C07;

    /**
     * 门锁设备楼层
     */
    private String C08;

    /**
     * 门锁设备流水号
     */
    private String C09;

    /**
     * 门锁设备微信开门锁号
     */
    private String C10;

    /**
     * 房间特征编码
     */
    private String C11;
}
