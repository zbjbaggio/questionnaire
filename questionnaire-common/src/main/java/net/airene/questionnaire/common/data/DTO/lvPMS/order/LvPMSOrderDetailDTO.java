package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiPang
 * @Desc 订单详情信息
 * @date 2021年08月31日 16:02
 */
@Data
public class LvPMSOrderDetailDTO implements Serializable {

    // 到店日期
    private String arrDate;

    // 价格
    //private String realRate;

    // 离店日期
    private String depDate;

    // 离店时间
    private String rsvDepDate;

    // 房型代码
    private String rmtype;

    // 房型描述
    private String rmTypeDescript;

    // 到点时间
    private String rsvArrDate;

    // 儿童数
    //private String children;

    // 资源id
    private String rsvSrcId;

    // 成人数
    //private String adult;

    // 账号
    private Long accnt;

    // 订单类型    RG -团队预订单，RF-普通预订单，MF-登记单
    //private String occFlag;

    // 房间数
    private Integer rmNum;

    // 价格明细
    //private List<LvPMSRsvRateDetailDTO> rsvRateDetail;

}
