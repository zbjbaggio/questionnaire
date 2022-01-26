package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 当前房量
 * @date 2021年05月27日 17:39
 */
@Data
public class LvPMSCurrentRoomCountReponseDTO {
    /**
     * 房型PMS编码
     */
    private String C00;

    /**
     * 该房型总房间数
     */
    private Integer C01;

    /**
     * 当前空净房数
     */
    private Integer C02;

    /**
     * 当前空脏房数
     */
    private Integer C03;

    /**
     * 当前维修房间数
     */
    private Integer C04;

    /**
     * 当前临时不可用房间数
     */
    private Integer C05;

    /**
     * 当前在住房间数
     */
    private Integer C06;
}
