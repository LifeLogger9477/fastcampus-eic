package com.example.moduleasandbox.repository;

import com.example.moduleasandbox.entity.Dummy;

import java.util.Optional;

/**
 * author : ms.Lee
 * date   : 2024-03-06
 */
public interface DummyRepository {

  Dummy save(Dummy dummy);

  Optional<Dummy> findByName(String name);

  int updateNameById(int id, String name);

  int deleteById(int id);
}
