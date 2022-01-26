package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

/**
 * @author LiPang
 * @Desc 可用房明细
 * @date 2021年09月01日 11:19
 */
@Data
public class LvPMSAvailRoomDTO {

    // 楼层代码
    private String floor;

    // 楼层代码描述
    private String floorDes;

    // 房型代码
    private String rmType;

    // 房型代码描述
    private String rmTypeDes;

    // 房号
    private String roomNo;

    // id
    //private String roomId;

    // 楼栋代码
    private String bulid;

    // 楼栋代码描述
    private String buildingDes;

    // 临时态
    //private String rmStaTmp;

    // 占用状态
    //private String rmStaOcc;

    // 房价状态
    //private String rmSta;
}
