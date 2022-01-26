package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 房费类型
 */
public enum LvPMSRoomChargeTypeEnum {
    UNLIMIT("0", "不限"),
    ALL_DAY_CHARGE("1", "全天房费"),
    HALF_DAY_CHARGE("2", "半天房费"),
    ;

    private final String code;
    private final String message;

    LvPMSRoomChargeTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
