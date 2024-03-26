package com.example.jdbcsandbox.repository;

import com.example.jdbcsandbox.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * author : ms.Lee
 * date   : 2024-03-26
 */
public interface UserJdbcRepository extends CrudRepository<User, Integer> {

  Optional<User> findByName(String name);

  List<User> findAllByGenderAndDeletedYn(String gender, Boolean deletedYn);
}
