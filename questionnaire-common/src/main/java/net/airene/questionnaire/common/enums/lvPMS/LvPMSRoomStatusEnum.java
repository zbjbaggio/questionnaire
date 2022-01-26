package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 房间状态
 */
public enum LvPMSRoomStatusEnum {
    UNKONWN("0", "未知"),
    EMPTY_CLEAN_ROOM("1", "空净房"),
    EMPTY_DIRTY_ROOM("2", "空脏房"),
    LIVING_ROOM("3", "在住房(脏或净)"),
    REPAIR_ROOM("4", "维修房"),
    TEMP_ROOM("5", "临时房"),
    ;

    private final String code;
    private final String message;

    LvPMSRoomStatusEnum(String code, String message) {
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
