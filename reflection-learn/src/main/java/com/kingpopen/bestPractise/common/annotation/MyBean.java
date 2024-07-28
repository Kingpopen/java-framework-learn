package com.kingpopen.bestPractise.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 自定义Bean注解
 * @date 2024/7/28 18:02:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface MyBean {

}
