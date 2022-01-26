package net.airene.questionnaire.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueryOrderTypeEnum {
    PHONE(2),
    IDCARD(1),
    NAME(3);
    
    private Integer value;
}
