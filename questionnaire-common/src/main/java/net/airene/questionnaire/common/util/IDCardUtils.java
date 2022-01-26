package net.airene.questionnaire.common.util;

import net.airene.questionnaire.common.enums.SexEnum;
import org.springframework.util.Assert;

public class IDCardUtils {

    public static SexEnum getSex(String IDCard) {
        Assert.notNull(StringUtils.isEmpty(IDCard), "IDCard must not be Empty");
        //15位身份证号
        if (IDCard.length() == 15) {
            if (Integer.parseInt(IDCard.substring(14, 15)) % 2 == 0) {
                return SexEnum.WOMAN;
            } else {
                return SexEnum.MAN;
            }
            //18位身份证号
        } else if (IDCard.length() == 18) {
            // 判断性别
            if (Integer.parseInt(IDCard.substring(16, 17)) % 2 == 0) {
                return SexEnum.WOMAN;
            } else {
                return SexEnum.MAN;
            }
        }
        throw new IllegalArgumentException("身份证格式不正确！");
    }

    public static String getBirthday(String IDCard) {
        Assert.notNull(StringUtils.isEmpty(IDCard), "IDCard must not be Empty");
        return IDCard.substring(6, 10) + "-" + IDCard.substring(10, 12) + "-" + IDCard.substring(12, 14);
    }
    
}
