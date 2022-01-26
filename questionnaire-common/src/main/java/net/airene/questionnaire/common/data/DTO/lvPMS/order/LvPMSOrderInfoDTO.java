package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 订单列表信息
 * @date 2021年08月27日 13:08
 */
@Data
public class LvPMSOrderInfoDTO implements Serializable {

    // 性别代码
    //private String sex;

    // 主单栏位中的付款方式代码
    //private String payCode;

    // 备注
    private String remark;

    // 入住人账号
    //private Long masterId;

    // 绿云预定号
    private String rsvNo;

    // 预订人姓名
    //private String rsvMan;

    // 房间数
    private Integer rmnum;

    // 协议单位(订房中心)账号 不存在默认为0
    //private Long sourceId;

    // 当前记录账号
    private Long id;

    // 预定单栏位中的付款方式
    //private String rsvPayCode;

    // 是否为预订单 F-否 T-是
    private String isRsv;

    // 预定单备注信息
    //private String rsvRemark;

    // 房型代码
    private String rmType;

    // 总的支付金额
    //private Double pay;

    // PMS来源代码
    private String src;

    // 总的预授权金额
    //private Double credit;

    // 离店时间
    private String dep;

    // 证件号
    //private String idNo;

    // PMS预定类型代码
    //private String rsvType;

    // 姓名
    private String guestName;

    // 订单类型 F-普订单，G-团队,D-钟点房
    //private String rsvClass;

    // 包价代码
    //private String packages;

    // 状态 R-预定 I-在住
    //private String sta;

    // 团队账号 不存在团队默认为0
    //private Long grpAccnt;

    // 入住时间
    private String arr;

    // 协议单位(旅行社)账号 不存在默认为0
    //private Long agentId;

    // 人数
    //private Integer adult;

    // 预定单账号 不存在默认为0
    //private Long rsvId;

    // 团队名称
    //private String groupManager;

    // 预定单预授权金额
    //private Double rsvCredit;

    // 总消费金额
    //private Double charge;

    // 市场代码
    //private String market;

    // 证件类型代码
    //private String idCode;

    // 预订单总付款金额
    //private Double rsvPay;

    // /预订单总消费金额
    //private Double rsvCharge;

    // 房号
    private String rmno;

    // 协议单位(协议公司)账号 不存在默认为0
    //private Long companyId;

    // 渠道代码
    private String channel;

    // 手机号
    private String mobile;

}
