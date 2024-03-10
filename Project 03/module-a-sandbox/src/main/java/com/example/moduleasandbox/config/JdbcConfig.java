package com.example.moduleasandbox.config;

import com.example.moduleasandbox.ModuleASandboxApplication;
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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * author : ms.Lee
 * date   : 2024-03-06
 */
@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories(
    basePackageClasses = ModuleASandboxApplication.class,
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

  @Bean
  public TransactionTemplate writeTransactionOperations(
      PlatformTransactionManager transactionManager
  ) {

    var transactionTemplate = new TransactionTemplate(transactionManager);
    transactionTemplate.setReadOnly(false);

    return transactionTemplate;
  }

  @Bean
  public TransactionTemplate readTransactionOperations(
      PlatformTransactionManager transactionManager
  ) {

    var transactionTemplate = new TransactionTemplate(transactionManager);
    transactionTemplate.setReadOnly(true);

    return transactionTemplate;
  }
}
