package com.tuling.spring.springFramework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 类描述
 * @date: 2024/04/26 10:33
 * @author: Heavy rain
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConponentScan {

    String value() default "";
}
