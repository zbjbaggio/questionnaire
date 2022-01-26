package net.airene.questionnaire.common.enums.enuo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 旅客换房返回结果
 */
@ToString
@Getter
@AllArgsConstructor
public enum EnuoGuestChangeResultEnum {
    SUCCESS("0000", "换房成功"),
    ;

    private final String code;
    private final String message;
    
    

}
