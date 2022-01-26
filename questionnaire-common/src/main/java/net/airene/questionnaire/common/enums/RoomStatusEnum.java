package net.airene.questionnaire.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LiPang
 * @Desc 房间状态
 * @date 2021年09月01日 15:24
 */
@Getter
@AllArgsConstructor
public enum RoomStatusEnum {
    FREE("V", "空闲"),
    TAKE_UP("O", "占用"),
    ;

    private final String key;

    private final String value;
}
