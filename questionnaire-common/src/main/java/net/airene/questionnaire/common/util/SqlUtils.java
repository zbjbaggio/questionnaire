package net.airene.questionnaire.common.util;

/**
 * sql操作工具类
 *
 * @author ruoyi
 */
public final class SqlUtils {

    private SqlUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * 仅支持字母、数字、下划线、空格、逗号（支持多个字段排序）
     */
    public static final String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,]+";

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value) {
        if (!StringUtils.isEmpty(value) && !isValidOrderBySql(value)) {
            return "";
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }
}
