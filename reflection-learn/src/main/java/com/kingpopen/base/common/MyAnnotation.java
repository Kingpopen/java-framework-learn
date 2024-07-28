package com.kingpopen.base.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 自定义注解
 * @date 2024/7/28 16:33:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {
}
