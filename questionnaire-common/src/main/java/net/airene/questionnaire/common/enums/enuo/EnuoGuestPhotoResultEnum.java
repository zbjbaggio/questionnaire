package net.airene.questionnaire.common.enums.enuo;

import lombok.ToString;

/**
 * 旅客证件照片返回结果
 */
@ToString
public enum EnuoGuestPhotoResultEnum {
    SUCCESS("0000", "对比成功"),
    ;

    private final String code;
    private final String message;

    EnuoGuestPhotoResultEnum(String code, String message) {
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
