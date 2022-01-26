package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 支付方式
 */
public enum LvPMSPayMethodEnum {
    MEMBER_CARD_BALANCE("5", "会员卡储值余额"),
    BANK_CARD_INSIDE("6", "银行卡内卡"),
    BANK_CARD_OUTSIDE("7", "银行卡外卡"),
    ZFB("12", "支付宝"),
    WX("141", "微信"),
    ;

    private final String code;
    private final String message;

    LvPMSPayMethodEnum(String code, String message) {
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
