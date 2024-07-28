package com.kingpopen.base.model;

import com.kingpopen.base.common.MyAnnotation;
import lombok.Data;


/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 实体类
 * @date 2024/7/28 15:18:06
 */
@Data
public class User {
  @MyAnnotation
  private String username;
  private int age;
  private String address;

  public String publicFiled;
  public static String PUBLIC_STATIC_FIELD = "PUBLIC_USER_NAME";
  private static String PRIVATE_STATIC_FIELD = "PRIVATE_USER_NAME";

  static {
    System.out.println("执行静态方法");
  }

  public User() {
  }

  public User(String username, int age, String address) {
    this.username = username;
    this.age = age;
    this.address = address;
  }

  private void privateFunc() {
    System.out.println("private func");
  }

  @MyAnnotation
  public void publicFunc() {
    System.out.println("public func");
  }

  public static void publicStaticFunc() {
    System.out.println("public static func");
  }

  public static void privateStaticFunc(){
    System.out.println("private static func");
  }

  public static void privateStaticFuncWithParam(String content){
    System.out.println("private static func with param, param is:" + content);
  }

  public void privateFuncWithParam(String content){
    System.out.println("private func with param, param is:" + content);
  }
}
