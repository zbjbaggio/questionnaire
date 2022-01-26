package net.airene.questionnaire.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author LiPang
 * @Desc 将DTO的属性值拼接成字符串
 * @date 2021年06月02日 10:32
 */
public final class DTOConvertUtils {

    private DTOConvertUtils() {
        throw new UnsupportedOperationException();
    }

    private final static String GET = "get";

    public static String dtoToString(Object object) throws Exception {
        if (object != null) {
            Object val;
            StringBuilder sb = new StringBuilder();
            // 拿到该类
            Class<?> clz = object.getClass();
            // 获取实体类的所有属性，返回Field数组
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                Method m = (Method) object.getClass().getMethod(GET + getMethodName(field.getName()));
                val = (Object) m.invoke(object);// 调用getter方法获取属性值
                if (val == null) {
                    sb.append("").append(",");
                } else {
                    sb.append(val).append(",");
                }
            }
            return sb.toString();
        }
        return null;
    }

    // 把一个字符串的第一个字母大写、效率是最高的
    private static String getMethodName(String fieldName) {
        return fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
    }

}
