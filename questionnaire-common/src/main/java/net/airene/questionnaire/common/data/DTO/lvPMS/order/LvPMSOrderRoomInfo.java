package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 订单返回类
 * @date 2021年09月02日 16:40
 */
@Data
public class LvPMSOrderRoomInfo implements Serializable {

    // 房型代码
    private String rmType;

    // 房间号
    private String roomNo;

    // 房型描述
    private String rmtypeDes;

    // 楼栋
    private String buildingDes;

    // 楼层
    private String floorDes;

    // 客房特征描述
    private String featureDes;

    // 住客姓名
    private String guestName;

    // 入店时间
    private String rsvArrDate;

    // 离店时间
    private String rsvDepDate;

    // 入住单id
    private Long accnt;

    // 资源id
    private String rsvSrcId;

    // 是否是预订单
    private String rsvType;

    // 结果描述，1 有空房 2 无空房
    private Integer description;

    // 备注
    private String remark;

    // 绿云预定号
    private String rsvNo;

    // 渠道代码
    private String channel;

    // 渠道描述
    private String channelDes;

    // 手机号
    private String mobile;

    private String src;

    private String srcDes;
}
