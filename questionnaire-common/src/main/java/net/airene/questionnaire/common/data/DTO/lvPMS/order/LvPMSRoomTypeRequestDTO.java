package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 房型信息请求类
 * @date 2021/11/16
 */
@Data
public class LvPMSRoomTypeRequestDTO implements Serializable {

    // 酒店代码
    private String hotelCode;
}
