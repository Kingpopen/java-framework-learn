package com.kingpopen.bestPractise;

import com.kingpopen.bestPractise.common.annotation.MyAutowired;
import com.kingpopen.bestPractise.common.annotation.MyBean;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 容器类
 * @date 2024/7/28 18:04:08
 */
public class Container {

  private Map<Class<?>, Method> methods;
  private Map<Class<?>, Object> beans;
  private Object config;

  /**
   * 初始化
   * @throws ClassNotFoundException
   * @throws InstantiationException
   * @throws IllegalAccessException
   * @throws NoSuchMethodException
   * @throws InvocationTargetException
   */
  public void init()
      throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    this.methods = new HashMap<>();
    this.beans = new ConcurrentHashMap<>();
    Class<?> clazz = Class.forName("com.kingpopen.bestPractise.common.config.Config");
    Method[] declaredMethods = clazz.getDeclaredMethods();
    Arrays.stream(declaredMethods).forEach(method -> {
      if (method.getAnnotation(MyBean.class) != null){
        methods.put(method.getReturnType(), method);
      }
    });

    config = clazz.getConstructor().newInstance();
  }

  /**
   * 通过Class类型 获取Bean对象
   * @param clazz
   * @return
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  public Object getBeanByClass(Class<?> clazz)
      throws InvocationTargetException, IllegalAccessException {
    if (beans.containsKey(clazz)){
      return beans.get(clazz);
    }

    if (!methods.containsKey(clazz)){
      return null;
    }

    synchronized (this){
      if (beans.containsKey(clazz)){
        return beans.get(clazz);
      }
      Method method = methods.get(clazz);
      method.setAccessible(true);
      Object obj = method.invoke(config);
      beans.put(clazz, obj);
      return obj;
    }
  }

  public Object newInstance(Class<?> clazz)
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    if (beans.containsKey(clazz)){
      return beans.get(clazz);
    }

    Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
    for (Constructor<?> constructor : declaredConstructors) {
      if (constructor.getAnnotation(MyAutowired.class) != null) {
        Parameter[] parameters = constructor.getParameters();
        List<Object> arguments = new ArrayList<>();
        for (Parameter param : parameters) {
          Object bean = getBeanByClass(param.getType());
          arguments.add(bean);
        }
        beans.put(clazz, constructor.newInstance(arguments.toArray()));
        return getBeanByClass(clazz);
      }
    }

    beans.put(clazz, clazz.getConstructor().newInstance());
    return getBeanByClass(clazz);
  }

}
