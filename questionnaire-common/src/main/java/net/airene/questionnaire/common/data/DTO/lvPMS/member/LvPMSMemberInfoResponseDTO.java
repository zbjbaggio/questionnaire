package net.airene.questionnaire.common.data.DTO.lvPMS.member;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 会员信息
 * @date 2021年05月27日 17:12
 */
@Data
public class LvPMSMemberInfoResponseDTO {
    /**
     * 会员级别PMS编码(会员卡类型ID)
     */
    private String C00;

    /**
     * 会员卡号
     */
    private String C01;

    /**
     * 姓名
     */
    private String C02;

    /**
     * 生日
     */
    private String C03;

    /**
     * 手机号
     */
    private String C04;

    /**
     * 证件类型
     */
    private String C05;

    /**
     * 证件号码
     */
    private String C06;

    /**
     * 会员卡余额(没有时, 返回0)
     */
    private String C07;

    /**
     * 会员卡状态(R-初始,I-有效,X-销卡,L-挂失,M-损坏,O-停用,S=休眠)
     */
    private String C08;

    /**
     * 会员对应房价码(为空则无,房价码A|房价码B)
     */
    private String C09;

    /**
     * 会员延迟退房时间(为空则无)
     */
    private String C10;

    /**
     * 总消费
     */
    private String C11;

    /**
     * 冻结总金额
     */
    private String C12;

    /**
     * 关联电子券信息
     */
    private String C13;
}
