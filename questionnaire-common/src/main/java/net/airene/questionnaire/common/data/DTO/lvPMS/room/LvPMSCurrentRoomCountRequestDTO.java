package net.airene.questionnaire.common.data.DTO.lvPMS.room;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询当前房量DTO
 * @date 2021年05月27日 17:36
 */
@Data
public class LvPMSCurrentRoomCountRequestDTO {
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
     * 楼宇PMS编码
     */
    private String Q04;
}
