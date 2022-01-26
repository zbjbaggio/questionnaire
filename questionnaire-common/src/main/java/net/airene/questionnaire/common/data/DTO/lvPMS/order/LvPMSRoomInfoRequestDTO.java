package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 查询房间信息请求类
 * @date 2021年08月31日 17:17
 */
@Data
public class LvPMSRoomInfoRequestDTO implements Serializable {

    // 酒店代码
    private String hotelCode;

    // 房间号
    private String roomNo;
}
