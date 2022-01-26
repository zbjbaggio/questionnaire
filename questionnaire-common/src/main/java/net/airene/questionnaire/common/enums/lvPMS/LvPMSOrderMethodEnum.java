package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 下单方式
 */
public enum LvPMSOrderMethodEnum {
    UNLIMIT("0", "不限"),
    WALKIN("1", "WalkIn入住"),
    HOTEL_RESERVE("2", "酒店预订"),
    CRS_RESERVE("3", "CRS预订"),
    WEB_RESERVE("4", "网站预订"),
    MOBILE_RESERVE("5", "手机预订"),
    SELF_MACHINE("6", "自助机"),
    BOOKING_PLATFORM("7", "预订平台对接"),
    ;

    private final String code;
    private final String message;

    LvPMSOrderMethodEnum(String code, String message) {
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
