package com.kingpopen.io;

import java.io.InputStream;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 解析url
 * @date 2024/7/30 17:29:14
 */
public class Resource {
  public static InputStream getInputStream(final String url) {
    return Resource.class.getResourceAsStream(url);
  }
}
