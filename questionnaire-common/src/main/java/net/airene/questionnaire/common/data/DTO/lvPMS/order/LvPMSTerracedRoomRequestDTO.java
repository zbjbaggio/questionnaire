package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 排房请求类
 * @date 2021年09月02日 13:57
 */
@Data
@ToString(callSuper = true)
public class LvPMSTerracedRoomRequestDTO extends BaseRequestDTO implements Serializable {

    // 酒店代码
    private String hotelCode;

    // 订单号
    private String accnt;

    // 房号
    private String roomNo;

    // 资源id
    private String rsvSrcId;
}
