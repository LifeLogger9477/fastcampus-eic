package com.example.multimodulea.config;

import com.example.multimodulea.MultiModuleAApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * author : ms.Lee
 * date   : 2024-03-03
 */
@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories(
    basePackageClasses = MultiModuleAApplication.class,
    jdbcOperationsRef = "parameterJdbcOperations",
    transactionManagerRef = "transactionManager"
)
public class JdbcConfig extends AbstractJdbcConfiguration {

  @Bean
  @Primary
  public NamedParameterJdbcOperations parameterJdbcOperations(
      @Qualifier("dataSource") DataSource dataSource
  ) {

    return new NamedParameterJdbcTemplate(dataSource);
  }

  @Bean
  @Primary
  public TransactionManager transactionManager(
      @Qualifier("dataSource") DataSource dataSource
  ) {

    return new DataSourceTransactionManager(dataSource);
  }
}
