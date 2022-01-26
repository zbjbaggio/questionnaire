package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 担保类型
 */
public enum LvPMSAssureTypeEnum {
    UNLIMIT("0", "不限"),
    UN_ASSURE("1", "未担保"),
    ASSURE_ALL("2", "担保全部"),
    ASSURE_FIRST_DAY("3", "担保首日"),
    ;

    private final String code;
    private final String message;

    LvPMSAssureTypeEnum(String code, String message) {
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
