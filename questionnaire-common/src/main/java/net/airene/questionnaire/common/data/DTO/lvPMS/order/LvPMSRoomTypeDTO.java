package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 房型信息
 * @date 2021/11/16
 */
@Data
public class LvPMSRoomTypeDTO implements Serializable {

    // 是否停用 F-否 T-是
    private String isHalt;

    // 房价数量
    private String quantity;

    // 房型描述
    private String rmTypeDes;

    // 房型代码
    private String rmType;
}
