package net.airene.questionnaire.common.enums.lvPMS;

/**
 * 证件类型
 */
public enum LvPMSDocumentTypeEnum {
    UNLIMIT("0", "不限"),
    IDCARD("1", "身份证"),
    PASSPORT("2", "护照"),
    DRIVING_LICENSE("3", "驾照"),
    WORK_CARD("4", "工作证"),
    MILITARY_CARD("5", "军官证"),
    STUTENT_CARD("6", "学生证"),
    TAI_CARD("7", "台胞证"),
    GANGAO_CARD ("8", "港澳回乡证"),
    OTHER_CARD("9", "其他"),
    ;

    private final String code;
    private final String message;

    LvPMSDocumentTypeEnum(String code, String message) {
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
