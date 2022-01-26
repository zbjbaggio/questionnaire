package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 预订单分房请求DTO
 * @date 2021年05月27日 18:59
 */
@Data
public class LvPMSReserveOrderRoomRequestDTO {
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
     * 预订单PMS编码
     */
    private String Q03;

    /**
     * 预留PMS编码
     */
    private String Q04;

    /**
     * 房号(多个房号之间使用|符号隔开)
     */
    private String Q05;
}
