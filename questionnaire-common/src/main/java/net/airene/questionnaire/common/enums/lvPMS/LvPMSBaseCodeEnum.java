package net.airene.questionnaire.common.enums.lvPMS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author LiPang
 * @Desc
 * @date 2021年08月31日 18:38
 */
@ToString
@Getter
@AllArgsConstructor
public enum LvPMSBaseCodeEnum {
    MARKET("market", "市场代码"),
    SRC("src", "来源代码"),
    CHANNEL("channel", "渠道代码"),
    RSV_TYPE("rsvType", "预定类型代码"),
    VISA_TYPE("visaType", "签证类型代码"),
    ENTER_PORT("enterPort", "入境口岸代码"),
    ID_CODE("idCode", "证件类型代码"),
    SEX("sex", "性别代码"),
    FEATURE("feature", "房间特征"),
    PACKAGE("package", "包价"),
    FLOOR("floor", "楼层"),
    BUILDING("building", "楼栋"),
    ROOM_STA("roomSta", "房态代码"),
    ROOM_STA_OCC("roomStaOcc", "空闲/占用标识"),
    CODE_ROOM_TPM("codeRoomTmp", "临时态代码"),
    ROOM_TYPE("roomType", "房型代码"),
    RACE("race", "民族代码"),
    ;

    private final String code;
    private final String message;
}
