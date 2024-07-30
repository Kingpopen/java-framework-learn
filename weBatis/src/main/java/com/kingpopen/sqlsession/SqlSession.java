package com.kingpopen.sqlsession;

import java.util.List;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description SqlSession 接口
 * SqlSession 是一个门面，提供了一些操作数据的接口
 * @date 2024/7/30 16:54:52
 */
public interface SqlSession {
  <E> List<E> selectList();

  <T> T selectOne();
}
