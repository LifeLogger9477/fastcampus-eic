package com.example.multimodulea.repository;

import com.example.multimodulea.entity.Dummy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author : ms.Lee
 * date   : 2024-03-04
 */
public class DummyCustomRowMapper implements RowMapper<Dummy> {

  @Override
  public Dummy mapRow(ResultSet rs, int rowNum) throws SQLException {

    Dummy dummy = new Dummy();

    dummy.setId(rs.getInt("id"));
    dummy.setName(rs.getString("name"));

    return dummy;
  }
}
