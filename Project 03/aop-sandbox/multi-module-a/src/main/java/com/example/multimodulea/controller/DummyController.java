package com.example.multimodulea.controller;

import com.example.multimodulea.entity.Dummy;
import com.example.multimodulea.repository.DummyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-03-03
 */
@RestController
public class DummyController {

  private final DummyRepository dummyRepository;

  public DummyController(
      DummyRepository dummyRepository
  ) {

    this.dummyRepository = dummyRepository;
  }

  @GetMapping(value = "/api/v1/dummy/create")
  public Dummy create(@RequestParam String name) {

    Dummy dummy = new Dummy();
    dummy.setName(name);

    return dummyRepository.save(dummy);
  }
}
