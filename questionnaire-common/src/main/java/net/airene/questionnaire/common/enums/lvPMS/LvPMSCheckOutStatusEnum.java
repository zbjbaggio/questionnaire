package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 结账状态
 */
public enum LvPMSCheckOutStatusEnum {
    UNLIMIT("0", "不限"),
    NO_CHECK_OUT("1", "未结账"),
    HAS_CHECK_OUT("2", "已结账"),
    ;

    private final String code;
    private final String message;

    LvPMSCheckOutStatusEnum(String code, String message) {
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
