package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 可用房明细请求类
 * @date 2021年09月01日 11:24
 */
@Data
@ToString(callSuper = true)
public class LvPMSAvailRoomRequestDTO extends BaseRequestDTO implements Serializable {

    // 酒店代码
    private String hotelCode;

    // 到店时间
    private String arrDate;

    // 离店时间
    private String depDate;

    // 房型代码
    private String rmType;

    // 是否包含预定单占用的资源 T-是,默认否
    private String isHasResrv;

}
