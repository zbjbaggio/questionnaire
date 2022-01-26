package net.airene.questionnaire.common.enums.enuo;

import lombok.ToString;

/**
 * 旅客入住返回结果
 */
@ToString
public enum EnuoGuestInResultEnum {
    SUCCESS("0000", "保存入住信息成功"),
    ;

    private final String code;
    private final String message;

    EnuoGuestInResultEnum(String code, String message) {
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
