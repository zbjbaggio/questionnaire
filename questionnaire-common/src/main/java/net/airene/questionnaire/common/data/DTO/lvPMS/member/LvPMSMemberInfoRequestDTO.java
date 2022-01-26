package net.airene.questionnaire.common.data.DTO.lvPMS.member;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查询会员详情DTO
 * @date 2021年05月27日 17:20
 */
@Data
public class LvPMSMemberInfoRequestDTO {
    /**
     * 预留
     */
    private String Q00;

    /**
     * 预留
     */
    private String Q01;

    /**
     * 品牌PMS编码(空时不作筛选)
     */
    private String Q02;

    /**
     * 查询值类型(1-会员卡号,2-身份证号,3-手机号)
     */
    private String Q03;

    /**
     * 查询值
     */
    private String Q04;

    /**
     * 酒店PMS编码
     */
    private String Q05;

    /**
     * 会员卡密码类型(1-登录密码,2-消费密码)
     */
    private String Q06;

    /**
     * 会员卡密码;(Q03为1时,此项有值,当密码为空时,服务层不用验证密码)
     */
    private String Q07;
}
