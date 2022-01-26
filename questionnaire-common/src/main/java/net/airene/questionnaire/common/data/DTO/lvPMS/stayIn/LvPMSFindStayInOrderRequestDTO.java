package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查找入住单DTO
 * @date 2021年05月27日 19:10
 */
@Data
public class LvPMSFindStayInOrderRequestDTO {
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
     * 查询值类型(2-入住人身份证号,3-房号,4-入住单PMS编码);(“房号”可 以是模糊匹配)
     */
    private String Q03;

    /**
     * 查询值
     */
    private String Q04;
}
