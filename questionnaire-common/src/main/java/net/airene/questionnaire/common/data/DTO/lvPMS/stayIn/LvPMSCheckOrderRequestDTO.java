package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 是否存在入住单DTO
 * @date 2021年05月28日 10:06
 */
@Data
public class LvPMSCheckOrderRequestDTO {
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
     * 查询值类型
     * 2-身份证,3-房号,4-入住单PMS编码
     */
    private String Q03;

    /**
     * 查询值
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
}
