package com.kingpopen.sqlsession;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description SqlSessionFactory
 * @date 2024/7/30 16:53:54
 */
public interface SqlSessionFactory {

  /**
   * 获取一个sqlSession
   * @return
   */
  SqlSession openSqlSession();
}
