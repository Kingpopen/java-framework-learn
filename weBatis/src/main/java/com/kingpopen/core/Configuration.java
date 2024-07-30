package com.kingpopen.core;

import java.util.Map;
import javax.sql.DataSource;
import lombok.Data;

/**
 * @author 彭锦波
 * @project java-framework-learn
 * @description 配置类
 * @date 2024/7/30 17:31:00
 */
@Data
public class Configuration {
  private DataSource dataSource;
  private Map<String, MappedStatement> mappedStatementMap;
}
