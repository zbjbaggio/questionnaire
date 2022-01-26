package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 支付类型
 */
public enum LvPMSPayTypeEnum {
    UNPAID("0", "未支付<或不限>"),
    PRE_AUTHORIZATION("1", "预授权<信用>"),
    PREPAID("2", "预付"),
    SETTLEMENT("3", "结算"),
    ;

    private final String code;
    private final String message;

    LvPMSPayTypeEnum(String code, String message) {
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
