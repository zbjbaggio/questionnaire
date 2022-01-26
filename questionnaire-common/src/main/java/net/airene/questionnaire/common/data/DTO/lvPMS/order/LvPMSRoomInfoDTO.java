package net.airene.questionnaire.common.data.DTO.lvPMS.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiPang
 * @Desc 房间信息列表
 * @date 2021年08月31日 17:58
 */
@Data
public class LvPMSRoomInfoDTO implements Serializable {

    // 房型代码
    private String rmType;

    // 房号
    private String roomNo;

    // 房型代码描述
    private String rmtypeDes;

    // 房间对应锁流水号
    //private String lockLotNo;

    // 房间对应锁楼号
    //private String lockFloor;

    // 房间对应锁楼栋
    //private String lockBuilding;

    // PMS楼栋代码
    private String building;

    // PMS楼栋描述
    private String buildingDes;

    // PMS楼层代码
    private String floor;

    // PMS楼层描述
    private String floorDes;

    // 客房特征代码
    private String feature;

    // 客房特征描述
    private String featureDes;

    // 床数
    //private String bedNum;

    // 最多住人人数
    //private String gstNum;

    // 房间对应其他锁号
    //private String lockNoWx;

    // 房间对应锁号
    //private String lockNo;

    // 房态代码 R-干净,I-检查,D-脏房,S-锁定,O-维修,T-Touch-Up
    //private String rmSta;

    // 占用表示 V-空闲 O-占用
    private String rmStaOcc;

    // 临时态代码
    //private String rmStaTmp;

}
