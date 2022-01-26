package net.airene.questionnaire.common.data;

import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult implements Serializable {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResponseResult ok() {
        return ok(null);
    }

    public static ResponseResult ok(Object data) {
        ResponseResult responseResult1 = new ResponseResult(ErrorInfoEnum.SUCCESS.getValue(), ErrorInfoEnum.SUCCESS.getName(), data);
        return responseResult1;
    }

    public static ResponseResult build(ErrorInfoEnum errorInfoEnum) {
        return new ResponseResult(errorInfoEnum.getValue(), errorInfoEnum.getName(), null);
    }
    public static ResponseResult build(int errCode, String msg) {
        return new ResponseResult(errCode, msg, null);
    }

    public static ResponseResult buildForValidated() { return build(ErrorInfoEnum.PARAMS_ERROR); }

    public ResponseResult(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }
}
