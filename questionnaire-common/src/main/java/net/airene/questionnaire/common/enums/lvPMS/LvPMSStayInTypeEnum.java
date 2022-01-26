package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 入住类型(时间属性)
 */
public enum LvPMSStayInTypeEnum {
    UNLIMIT("0", "不限"),
    STANDARD_ROOM("1", "过夜房<普通房>"),
    MORNING_ROOM("2", "凌晨房"),
    HOUR_ROOM("3", "钟点房"),
    LONG_BOOKING_ROOM("4", "长包房"),
    ;

    private final String code;
    private final String message;

    LvPMSStayInTypeEnum(String code, String message) {
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
