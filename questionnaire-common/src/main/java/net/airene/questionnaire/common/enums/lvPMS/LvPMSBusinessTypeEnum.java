package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 营业类别
 */
public enum LvPMSBusinessTypeEnum {
    UNLIMIT("0", "不限"),
    GUEST_ROOM("1", "客房"),
    CATERING("2", "餐饮"),
    BUSINSEE_CENTER("3", "商务中心"),
    SUPERMARKET("4", "超市"),
    OTHER("5", "其他"),
    ;

    private final String code;
    private final String message;

    LvPMSBusinessTypeEnum(String code, String message) {
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
