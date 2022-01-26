package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 交易类型
 */
public enum LvPMSTradeTypeEnum {
    UNLIMIT("0", "不限"),
    CREDIT_CARD_CONSUME("1", "刷卡消费"),
    ;

    private final String code;
    private final String message;

    LvPMSTradeTypeEnum(String code, String message) {
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
