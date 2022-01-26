package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查找订单
 * @date 2021年05月27日 18:49
 */
@Data
public class LvPMSFindOrderRequestDTO {
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
     * 查询值类型(1-订单号,2-预订人身份证号,3-预订人手机号,
     * 5-入住人姓名,6-身份证号#入住人姓名);]
     */
    private String Q03;

    /**
     * 查询值(查询值类型为4时,此项为空)
     */
    private String Q04;

    /**
     * 订单预计入住日期
     */
    private String Q05;
}
