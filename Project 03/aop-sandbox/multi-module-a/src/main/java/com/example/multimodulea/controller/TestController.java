package com.example.multimodulea.controller;

import com.example.multimodulea.entity.Test;
import org.springframework.web.bind.annotation.*;

/**
 * author : ms.Lee
 * date   : 2024-03-06
 */
@RestController
public class TestController {

  @GetMapping(value = "/api/v1/test/{testId}")
  public String getTest(@PathVariable Integer testId) {

    return "testId";
  }

  @GetMapping(value = "/api/v2/test/{testId}")
  public String getTest2(
      @PathVariable Integer testId,
      @RequestParam String name
  ) {

    return "testId2";
  }

  @PostMapping(value = "/api/v3/test/{testId}")
  public String getTest3(
      @PathVariable Integer testId,
      @RequestParam String name,
      @RequestBody Test test
  ) {

    return "test3";
  }
}
