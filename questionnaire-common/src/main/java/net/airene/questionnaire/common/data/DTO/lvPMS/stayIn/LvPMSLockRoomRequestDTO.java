package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 锁房请求DTO
 * @date 2021年05月27日 18:32
 */
@Data
public class LvPMSLockRoomRequestDTO {
    /**
     * 预留
     */
    private String Q00;

    /**
     * 业务类型(1-订单入住锁房,2-直接入住锁房)
     */
    private String Q01;

    /**
     * 是否强制操作(1-不强制,2-强制)
     */
    private String Q02;

    /**
     * 操作类型(1-上锁,2-解锁)
     */
    private String Q03;

    /**
     * 酒店PMS编码
     */
    private String Q04;

    /**
     * 楼宇PMS编号
     */
    private String Q05;

    /**
     * 房号PMS编码
     */
    private String Q06;

    /**
     * 设备人工编号
     */
    private String Q07;

    /**
     * 预订单PMS编码
     */
    private String Q08;
}
