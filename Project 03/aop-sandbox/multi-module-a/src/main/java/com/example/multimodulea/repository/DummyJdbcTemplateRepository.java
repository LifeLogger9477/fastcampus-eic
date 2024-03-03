package com.example.multimodulea.repository;

import com.example.multimodulea.entity.Dummy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * author : ms.Lee
 * date   : 2024-03-03
 */
@Component
public class DummyJdbcTemplateRepository implements DummyRepository {

  private final JdbcTemplate jdbcTemplate;
  private final TransactionTemplate writeTransactionOperations;
  private final TransactionTemplate readTransactionOperations;

  public DummyJdbcTemplateRepository(
      DataSource dataSource,
      TransactionTemplate writeTransactionOperations,
      TransactionTemplate readTransactionOperations
  ) {

    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.writeTransactionOperations = writeTransactionOperations;
    this.readTransactionOperations = readTransactionOperations;
  }

  @Override
  public Dummy save(Dummy dummy) {

    String sql = "insert into dummy values (?, ?)";
    writeTransactionOperations.executeWithoutResult(
        status -> {
          jdbcTemplate.update(
              sql,
              LocalDateTime.now().getNano(),
              dummy.getName()
          );
        }
    );

    return dummy;
  }

  @Override
  public Optional<Dummy> findByName(String name) {

    return Optional.empty();
  }


  @Override
  public int updateNameById(int id, String name) {

    return 0;
  }

  @Override
  public int deleteById(int id) {

    return 0;
  }
}
