package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 查找入住单
 * @date 2021年05月27日 19:11
 */
@Data
public class LvPMSFindStayInOrderResponseDTO {
    /**
     * 入住单PMS编码
     */
    private String C00;

    /**
     * 入住人姓名#证件号#民族#性别(男性或女性)#证件地址#生日#客人入住流水号#手机号
     */
    private String C01;

    /**
     * 入住时间
     */
    private String C02;

    /**
     * 离店时间
     */
    private String C03;

    /**
     * 房型PMS编码
     */
    private String C04;

    /**
     * 房号
     */
    private String C05;

    /**
     * 联房标记
     */
    private String C06;

    /**
     * 会员卡号
     */
    private String C07;

    /**
     * 入住类型
     */
    private String C08;

    /**
     * 会员卡级别PMS编码
     */
    private String C09;

    /**
     * 是否允许在自助设备上续住(1-是,2-否,3-自定义)(空时默认3)
     */
    private String C10;

    /**
     * 账单余额;(账单余额=总付款-总消费)
     */
    private String C11;

    /**
     * 预留
     */
    private String C12;

    /**
     * 每日房价
     */
    private String C13;
    /**
     * 是否用预授权入住(1-是,2-否)
     */
    private String C14;

    /**
     * 协议单位中文描述#订房中心描述#旅行社描述
     */
    private String C15;

    /**
     * 联房房间信息(预订单PMS编码#房号#房间状态);
     * 房间状态:I-在住,O-退房,N-系统取消,S-挂账,X-手工取消
     */
    private String C16;

    /**
     * 登记单付款PMS代码
     */
    private String C17;

    /**
     * 预定单付款PMS代码
     */
    private String C18;

    /**
     * 预定类型描述
     */
    private String C19;
}
