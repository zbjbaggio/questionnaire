package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查找订单
 * @date 2021年05月27日 18:51
 */
@Data
public class LvPMSFindOrderResponseDTO {
    /**
     * 预订单PMS编码
     */
    private String C00;

    /**
     * 预订人名称
     */
    private String C01;

    /**
     * 入住人名称(多个时,就用空格隔开拼接)
     */
    private String C02;

    /**
     * 预订人手机号
     */
    private String C03;

    /**
     * 预订时间
     */
    private String C04;

    /**
     * 抵达日期
     */
    private String C05;

    /**
     * 离店日期
     */
    private String C06;

    /**
     * 担保类型
     */
    private String C07;

    /**
     * 已支付金额
     */
    private String C08;

    /**
     * 房型PMS编码
     */
    private String C09;

    /**
     * 房间数量
     */
    private String C10;

    /**
     * 房号
     */
    private String C11;

    /**
     * 入住日期#成交房价#原始房价
     */
    private String C12;

    /**
     * 入住日期#早餐份数
     */
    private String C13;
    /**
     * 会员卡号
     */
    private String C14;

    /**
     * 会员级别PMS编码
     */
    private String C15;

    /**
     * 协议单位名称
     */
    private String C16;

    /**
     * 渠道商名称
     */
    private String C17;

    /**
     * 订单号
     */
    private String C18;

    /**
     * 备注
     */
    private String C19;

    /**
     * 入住类型
     */
    private String C20;

    /**
     * 预付的支付方式
     */
    private String C21;

    /**
     * 联房标记
     */
    private String C22;

    /**
     * 是否是主订单(1-是,2-否)【不联房时是1】(如果PMS不存在主订单概念,直接返回1)
     */
    private String C23;

    /**
     * PMS房价码
     */
    private String C24;

    /**
     * 房价是否保密
     */
    private String C26;

    /**
     * 预订单ID
     */
    private String C28;

    /**
     * 状态
     */
    private String C29;
    /**
     * 纯预留ID
     */
    private String C30;

    /**
     * 散客/团队类型区分(F-散客,G-团队)
     */
    private String C31;

    /**
     * 市场
     */
    private String C33;

    /**
     * 渠道
     */
    private String C34;

    /**
     * 来源
     */
    private String C35;

    /**
     * 预订类型
     */
    private String C36;

    /**
     * 信用住订单标记
     */
    private String C37;

    /**
     * 联房房间信息(预订单PMS编码#房号#房间状态);
     * 房间状态:I-在住,O-退房,N-系统取消,S-挂账,X-手工取消
     */
    private String C40;
}
