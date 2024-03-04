package com.example.multimodulea.repository;

import com.example.multimodulea.entity.Dummy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
  // private final TransactionTemplate writeTransactionOperations;
  // private final TransactionTemplate readTransactionOperations;

  public DummyJdbcTemplateRepository(
      DataSource dataSource/*,
      TransactionTemplate writeTransactionOperations,
      TransactionTemplate readTransactionOperations
      */
  ) {

    this.jdbcTemplate = new JdbcTemplate(dataSource);
//    this.writeTransactionOperations = writeTransactionOperations;
//    this.readTransactionOperations = readTransactionOperations;
  }

  @Override
  public Dummy save(Dummy dummy) {

    String sql = "insert into dummy values (?, ?)";
    jdbcTemplate.update(sql, LocalDateTime.now().getNano(), dummy.getName());
    /*
    writeTransactionOperations.executeWithoutResult(
        status -> {
          jdbcTemplate.update(
              sql,
              LocalDateTime.now().getNano(),
              dummy.getName()
          );
        }
    );
     */

    return dummy;
  }

  @Override
  public Optional<Dummy> findByName(String name) {

    String sql = "select * from dummy where name = ?";
    List<Dummy> dummies =
        jdbcTemplate.query(sql, new DummyCustomRowMapper(), name);

    return Optional.ofNullable(dummies.get(0));
  }


  @Override
  public int updateNameById(int id, String name) {

    String sql = "update dummy set name = ? where id = ?";

    return jdbcTemplate.update((Connection conn) -> {

      PreparedStatement preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1, name);
      preparedStatement.setInt(2, id);

      return preparedStatement;
    });
  }

  @Override
  public int deleteById(int id) {

    String sql = "delete from dummy where id = ?";

    /*
    return jdbcTemplate.update(sql, id);
     */

    return jdbcTemplate.update((Connection conn) -> {

      PreparedStatement preparedStatement = conn.prepareStatement(sql);

      preparedStatement.setInt(1, id);

      return preparedStatement;
    });
  }
}
