package net.airene.questionnaire.common.enums.enuo;

import lombok.ToString;

/**
 * 旅客退房返回结果
 */
@ToString
public enum EnuoGuestOutResultEnum {
    SUCCESS("0000", "退房成功"),
    ;

    private final String code;
    private final String message;

    EnuoGuestOutResultEnum(String code, String message) {
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
