package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 价格类别
 */
public enum LvPMSPriceTypeEnum {
    UNLIMIT("0", "不限"),
    LIST_PRICE("1", "挂牌价"),
    INDIVIDUAL_PRICE("2", "散客价<前台价>"),
    MEMBER_PRICE("3", "会员价"),
    ;

    private final String code;
    private final String message;

    LvPMSPriceTypeEnum(String code, String message) {
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
