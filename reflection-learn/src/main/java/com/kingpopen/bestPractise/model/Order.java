package com.kingpopen.bestPractise.model;

import com.kingpopen.bestPractise.common.annotation.MyAutowired;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 订单类
 * @date 2024/7/28 17:57:49
 */
@Data
@NoArgsConstructor
public class Order {
  private Custom custom;
  private Address address;

  @MyAutowired
  public Order(Custom custom, Address address){
    this.custom = custom;
    this.address = address;
  }
}
