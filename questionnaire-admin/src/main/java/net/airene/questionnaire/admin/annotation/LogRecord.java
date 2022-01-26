package net.airene.questionnaire.admin.annotation;

import java.lang.annotation.*;

/**
 * 日志注解  用于记录报表日志
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LogRecord {

    /**
     * 方法中文名
     * @return
     */
    String value() default "";

}
