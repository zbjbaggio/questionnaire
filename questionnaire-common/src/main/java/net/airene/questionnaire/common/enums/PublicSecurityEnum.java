package net.airene.questionnaire.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PublicSecurityEnum {

    ENUO(1, "enuoServiceImpl");

    private Integer key;

    private String value;

    public static String getValue(Integer index) {
        for (PublicSecurityEnum c : PublicSecurityEnum.values()) {
            if (c.getKey().equals(index)) {
                return c.value;
            }
        }
        return null;
    }

}
