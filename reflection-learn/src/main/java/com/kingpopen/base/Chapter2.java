package com.kingpopen.base;

import com.kingpopen.base.common.MyAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 如何获取属性 和 方法
 * @date 2024/7/28 16:05:26
 */
@Slf4j
public class Chapter2 {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
//    getFiled();
//    getMethod();
    getAnnotation();
//    changeField();
//    invokeMethod();
//    createAndOperatorInstance();
  }

  /**
   * 获取属性
   */
  public static void getFiled() throws ClassNotFoundException {
      Class<?> clazz = Class.forName("com.kingpopen.base.model.User");
      // 1. getFields 只能获取 public 的属性
      Field[] fields = clazz.getFields();
      Arrays.stream(fields).forEach(field -> log.info(field.getName()));

      // 2. getDeclaredFields 获取所有的属性
      Field[] declaredFields = clazz.getDeclaredFields();
      Arrays.stream(declaredFields).forEach(field -> log.info(field.getName()));
  }

  /**
   * 获取方法
   */
  public static void getMethod() throws ClassNotFoundException {
    Class<?> clazz = Class.forName("com.kingpopen.base.model.User");
    // 1. getMethods 只能获取 public 的方法
    Method[] methods = clazz.getMethods();
    Arrays.stream(methods).forEach(method -> log.info(method.getName()));

    // 2. getDeclaredMethods 获取所有 的方法
    Method[] declaredMethods = clazz.getDeclaredMethods();
    Arrays.stream(declaredMethods).forEach(method -> log.info(method.getName()));

  }

  public static void getAnnotation() throws ClassNotFoundException {
    Class<?> clazz = Class.forName("com.kingpopen.base.model.User");

    // 1. 获取属性 和 方法
    Field[] declaredFields = clazz.getDeclaredFields();
    Method[] declaredMethods = clazz.getDeclaredMethods();

    Arrays.stream(declaredFields).forEach(field -> {
      if (field.getAnnotation(MyAnnotation.class) != null){
        System.out.println("field is:" + field.getName());
      }
    });

    Arrays.stream(declaredMethods).forEach(method -> {
      if (method.getAnnotation(MyAnnotation.class) != null) {
        System.out.println("method is:" +  method.getName());
      }
    });
  }


  /**
   * 修改属性
   */
  public static void changeField()
      throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    Class<?> clazz = Class.forName("com.kingpopen.base.model.User");

    // 公有的静态属性修改
    Field publicStaticField = clazz.getDeclaredField("PUBLIC_STATIC_FIELD");
    System.out.println("public static field is:" + publicStaticField.get(null).toString());
    // 因为是静态方法，传入的对象是null就可以
    publicStaticField.set(null, "change it");
    System.out.println("after change public static field is:" + publicStaticField.get(null).toString());

    // 私有的静态属性修改
    Field privateStaticField = clazz.getDeclaredField("PRIVATE_STATIC_FIELD");
    privateStaticField.setAccessible(true);
    System.out.println("private static field is:" + privateStaticField.get(null).toString());
    privateStaticField.set(null, "change it");
    System.out.println("after change private static field is:" + privateStaticField.get(null).toString());
  }

  /**
   * 执行方法
   */
  public static void invokeMethod()
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Class<?> clazz = Class.forName("com.kingpopen.base.model.User");
    // 公有静态方法
    Method publicStaticFunc = clazz.getDeclaredMethod("publicStaticFunc");
    publicStaticFunc.invoke(null);


    // 私有带参数的静态方法
    Method privateStaticFuncWithParam = clazz.getDeclaredMethod("privateStaticFuncWithParam",
        String.class);
    privateStaticFuncWithParam.setAccessible(true);
    privateStaticFuncWithParam.invoke(null, "Hello World!");
  }

  /**
   * 通过反射创建实例
   */
  public static void createAndOperatorInstance()
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<?> clazz = Class.forName("com.kingpopen.base.model.User");

    Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
    Object obj = constructor.newInstance("kingpopen", 26, "深圳市");
    System.out.println("obj is:" + obj);

    // 改变名称
    Method setAddress = clazz.getMethod("setAddress", String.class);
    setAddress.invoke(obj, "New York");
    System.out.println("obj is:" + obj);

    // 调用方法
    Method method = clazz.getMethod("privateFuncWithParam", String.class);
    method.invoke(obj, "Hello World!");
  }
}
