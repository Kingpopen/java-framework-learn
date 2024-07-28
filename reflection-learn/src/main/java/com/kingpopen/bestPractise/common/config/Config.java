package com.kingpopen.bestPractise.common.config;

import com.kingpopen.bestPractise.common.annotation.MyBean;
import com.kingpopen.bestPractise.model.Address;
import com.kingpopen.bestPractise.model.Custom;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 配置类
 * @date 2024/7/28 17:57:21
 */
public class Config {
  @MyBean
  public Custom custom(){
    return new Custom("kingpopen");
  }
  @MyBean
  public Address address(){
    return new Address("深圳市");
  }
}
