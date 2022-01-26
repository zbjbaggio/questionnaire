package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 续住请求DTO
 * @date 2021年05月27日 19:06
 */
@Data
public class LvPMSRenewalStayRequestDTO {
    /**
     * 自助厂家标识代码
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
     * 入住单PMS编码#离店时间(格式: yyyy-MM-dd HH:mm:ss)#入住单原入住类型
     */
    private String Q03;

    /**
     * 日期(格式:yyyy-MM-dd HH:mm:ss)#成交房价#原始房价#预留位#入住单PMS编码
     */
    private String Q04;

    /**
     * 预留
     */
    private String Q05;

    /**
     * 预留
     */
    private String Q06;

    /**
     * 班别PMS编码(1-早班,2-中班,3-晚班,4-夜审)
     */
    private String Q07;

    /**
     * 预留
     */
    private String Q08;

    /**
     * 设备人工编号
     */
    private String Q09;
}
