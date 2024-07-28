package com.kingpopen.base;

import com.kingpopen.base.model.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 案例1-获取类的类对象
 * @date 2024/7/28 15:17:27
 */
@Slf4j
public class Chapter1 {

  public static void main(String[] args) {
//    System.out.println(" ==== 第一种方式 ===");
//    getClassObjectByDotClass();

//    System.out.println(" ==== 第二种方式 ===");
//    getClassObjectByGetClass();

    System.out.println(" ==== 第三种方式 ===");
    getClassObjectByClassDotForName();
  }

  public static void getClassObjectByDotClass(){
    // 1. 类的.class 方法 编译时就能确定类型
    Class<User> clazz = User.class;
  }

  public static void getClassObjectByGetClass(){
    // 2. 通过实例的getClass方法，类型需要在运行时才能确定
    User user = new User("kingpopen", 26, "深圳市");
    Class<?> clazz = user.getClass();
  }

  public static void getClassObjectByClassDotForName(){
    // 3. 通过Class.forName 方法
    try {
      Class<?> clazz = Class.forName("com.kingpopen.base.model.User");
    } catch (ClassNotFoundException e) {
      log.info("找不到类型，出现异常！");
    }
  }
}
