package com.gyq.learning.functional;

import java.lang.annotation.*;

/**
 * @author gaoyaqiu
 * @date 2019/2/24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DemoAnnotation {

    String value();
}
