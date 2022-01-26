package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 账目类别
 */
public enum LvPMSAccountTypeEnum {
    UNLIMIT("0", "不限"),
    CONSUME_ITEM("1", "消费项"),
    PAY_ITEM("2", "支付项<付款项>"),
    PRE_AUTHORIZATION("21", "预授权<信用>"),
    PAY_ITEM_PRE("22", "支付项-预付"),
    PAY_ITEM_SETTLE("23", "支付项-结算"),
    ;

    private final String code;
    private final String message;

    LvPMSAccountTypeEnum(String code, String message) {
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
