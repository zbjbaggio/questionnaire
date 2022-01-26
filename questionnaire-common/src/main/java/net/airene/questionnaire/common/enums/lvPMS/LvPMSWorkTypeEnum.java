package net.airene.questionnaire.common.enums.lvPMS;

/**
 * PMS班别
 */
public enum LvPMSWorkTypeEnum {
    MORNING_WORK("1", "早班"),
    NOON_WORK("2", "中班"),
    AFTERNOON_WORK("3", "晚班"),
    NIGHT_WORK("3", "夜审"),
    ;

    private final String code;
    private final String message;

    LvPMSWorkTypeEnum(String code, String message) {
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
