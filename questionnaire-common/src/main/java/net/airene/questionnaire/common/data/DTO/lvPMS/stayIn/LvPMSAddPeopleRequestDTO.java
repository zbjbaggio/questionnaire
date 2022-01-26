package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 增加同住人DTO
 * @date 2021年05月28日 10:17
 */
@Data
public class LvPMSAddPeopleRequestDTO {
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
     * 入住单PMS编码
     */
    private String Q03;

    /**
     * 入住人姓名#证件类型(见E11)#证件号#民族(文本)#性别(男性|女性|未知)#住址#出生(yyyy-MM-dd)#姓名全拼
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
     * 预留
     */
    private String Q07;
}
