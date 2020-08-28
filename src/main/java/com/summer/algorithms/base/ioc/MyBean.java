package com.summer.algorithms.base.ioc;

import java.lang.annotation.*;

/**
 * @author adminstor
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyBean {
    String value() default "";
}
