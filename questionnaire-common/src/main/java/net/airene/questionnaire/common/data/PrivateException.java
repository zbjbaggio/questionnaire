package net.airene.questionnaire.common.data;

import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * controller 异常
 * Created by eason on 2016-10-25.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PrivateException extends RuntimeException {

    private int code;

    private String msg;

    public PrivateException(ErrorInfoEnum errorInfoEnum) {
        super(errorInfoEnum.getName());
        this.code = errorInfoEnum.getValue();
        this.msg = errorInfoEnum.getName();
    }

    public PrivateException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public PrivateException() {
        super();
    }
}
