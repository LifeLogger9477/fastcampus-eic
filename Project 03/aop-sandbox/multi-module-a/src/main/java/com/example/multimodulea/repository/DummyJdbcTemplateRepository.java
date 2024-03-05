package com.example.multimodulea.repository;

import com.example.multimodulea.entity.Dummy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    return writeTransactionOperations.execute(status -> {

      String sql = "insert into dummy values (?, ?)";
      jdbcTemplate.update(sql, LocalDateTime.now().getNano(), dummy.getName());

      return dummy;
    });
  }

  @Override
  public Optional<Dummy> findByName(String name) {

    return readTransactionOperations.execute(status -> {

      String sql = "select * from dummy where name = ?";
      List<Dummy> dummies = jdbcTemplate.query(
          sql, (ResultSet rs, int rowNum) -> {

            Dummy dummy = new Dummy();
            dummy.setId(rs.getInt("id"));
            dummy.setName(rs.getString("name"));

            return dummy;
          },
          name
      );

      return Optional.ofNullable(dummies.get(0));
    });
  }


  @Override
  @Transactional(readOnly = false)
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
  @Transactional
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
