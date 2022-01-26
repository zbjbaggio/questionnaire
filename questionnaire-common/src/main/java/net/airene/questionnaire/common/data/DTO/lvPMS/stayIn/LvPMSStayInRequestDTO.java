package net.airene.questionnaire.common.data.DTO.lvPMS.stayIn;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 入住请求DTO
 * @date 2021年05月27日 18:39
 */
@Data
public class LvPMSStayInRequestDTO {
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
     * 预订单PMS编码
     */
    private String Q03;

    /**
     * 房型PMS编码
     */
    private String Q04;

    /**
     * 房号
     */
    private String Q05;

    /**
     * 房价码
     */
    private String Q06;

    /**
     * 总房费
     */
    private String Q07;

    /**
     * 入住日期#成交房价#原始房价
     */
    private String Q08;

    /**
     * 总餐券金额
     */
    private String Q09;

    /**
     * 入住日期#餐券种类编码#餐券数量#餐券单价
     */
    private String Q10;

    /**
     * 会员卡号#会员级别PMS编码
     */
    private String Q11;

    /**
     * 入住人姓名#证件类型(见E11)#证件号#民族(文本)#性别(男性|女性|未知)#住址#出生(yyyy-MM-dd)#姓名全拼
     */
    private String Q12;

    /**
     * 手机号
     */
    private String Q13;

    /**
     * 支付类型#支付方式#支付金额#自助设备支付记录编码# 交易流水号#工号PMS编码#操作时间#交易类型#卡号#有效期#授权码
     * (交易流水号是用来对账)
     * (工号PMS编码只对现金有效,其它自助的支付方式,就赋值第一个客人的姓名);
     * (支付宝时,交易流水号=支付宝流水号,卡号=支付宝支付帐号)
     * (会员卡支付时,自助设备支付记 录编码=会员卡刷卡记录编码)
     */
    private String Q14;

    /**
     * 预留
     */
    private String Q15;

    /**
     * 发卡数
     */
    private String Q16;

    /**
     * 设备人工
     */
    private String Q17;

    /**
     * 班别PMS编码;(1-早班,2-中班,3-晚班,4-夜审)
     */
    private String Q18;

    /**
     * 联房入住单PMS编码
     */
    private String Q19;

    /**
     * 入住时间
     * 格式:yyyy-MM-dd HH:mm:ss
     */
    private String Q20;

    /**
     * 离店时间
     * 格式:yyyy-MM-dd HH:mm:ss
     */
    private String Q21;

    /**
     * 入住类型
     */
    private String Q22;

    /**
     * 散团(1-散客,2-团队)
     */
    private String Q23;

    /**
     * 下单方式
     */
    private String Q24;

    /**
     * 下单时间
     */
    private String Q25;

    /**
     * 房号PMS编码
     */
    private String Q26;

    /**
     * 锁房标记值
     */
    private String Q27;

    /**
     * 日期#包价
     */
    private String Q28;

    /**
     * 备注
     */
    private String Q29;
}
