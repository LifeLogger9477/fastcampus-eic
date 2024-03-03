package com.example.multimodulea.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * author : ms.Lee
 * date   : 2024-03-03
 */
@Configuration
@PropertySource(
    value = "classpath:jdbc.properties",
    ignoreResourceNotFound = true
)
@PropertySource(
    value = "classpath:jdbc-${spring.profiles.active}.properties",
    ignoreResourceNotFound = true
)
public class DataSourceConfig {

  @Bean
  @ConfigurationProperties("datasource.jdbc")
  public DataSourceProperties dataSourceProperties() {

    return new DataSourceProperties();
  }

  @Bean
  public DataSource dataSource() {

    return dataSourceProperties().initializeDataSourceBuilder().build();
  }
}
