package net.airene.questionnaire.common.data;

import lombok.Data;

import java.util.Map;

@Data
public class ValidationResult {

    //校验结果是否有错
    private boolean hasErrors;

    //校验错误信息
    private Map<String,String> errorMsg;

    public String getErrorMsgStr() {
        StringBuilder message = new StringBuilder();
        String messageStr = "";
        if (null != errorMsg) {
            for (String msg : errorMsg.values()) {
                message.append(msg).append(",");
            }
            if(message.toString().length() > 0 ) {
                messageStr = message.toString().substring(0, message.length() - 1);
            }
        }

        return messageStr;
    }

    public boolean getHasErrors() {
        return hasErrors;
    }

}
