package com.kingpopen.bestPractise;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description
 * @date 2024/7/28 18:28:58
 */
public class Main {

  public static void main(String[] args)
      throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    Container container = new Container();
    container.init();

    Class<?> clazz = Class.forName("com.kingpopen.bestPractise.model.Address");
    Object bean = container.getBeanByClass(clazz);
    System.out.println("bean is:" + bean);

    Class<?> orderClazz = Class.forName("com.kingpopen.bestPractise.model.Order");
    container.newInstance(orderClazz);
    Object order = container.getBeanByClass(orderClazz);
    System.out.println("order is:" + order);
  }
}
