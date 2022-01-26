package net.airene.questionnaire.common.data.DTO.guest;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class TakeUpTimeDTO extends BaseRequestDTO implements Serializable {

    // 绿云预订号
    private String rsvNo;

    // 入住日期
    private Date rsvArrDate;

    // 离店日期
    private Date rsvDepDate;

    // 办理时间
    private Date startTime;

    // 入住房型
    private String rmType;

    // 入住房号
    private String roomNo;

    // 入住人姓名 张三，李四
    private String names;

    // 订单渠道
    private String channelDes;

    // 订单备注
    private String remark;

    private Long usedTimes;

}
