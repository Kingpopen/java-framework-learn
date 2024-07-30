package com.kingpopen.io;

import com.kingpopen.sqlsession.SqlSessionFactory;
import java.io.InputStream;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 构建SqlSessionFactory
 * @date 2024/7/30 16:47:42
 */
public class SqlSessionFactoryBuilder {
  public SqlSessionFactory build(final String url) throws ClassNotFoundException {
    // 1. 获取数据
    InputStream is = Resource.getInputStream(url);

    // 2. 解析数据

    // 3. 构造Configuration 类 (存放配置的数据源，事务管理器 sql语句 等内容)

    return null;
  }
}
