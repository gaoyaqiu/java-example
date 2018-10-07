package com.gyq.jpa.annoation.log;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface LogStyle {

    /**
     * 版本
     *
     * @return
     */
    String version() default "No printed version";


    /**
     * 标记
     *
     * @return
     */
    String tag() default "";

    /**
     * 方法执行之前的描述
     * 日志基本格式
     *
     * @return
     */
    String beforeDesc() default "";


    /**
     * 方法执行之后的
     * 日志基本格式
     *
     * @return
     */
    String afterDesc() default "";
}
