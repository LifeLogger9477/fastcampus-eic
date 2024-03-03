package com.example.multimodulea.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * author : ms.Lee
 * date   : 2024-03-03
 */
@Getter
@Setter
public class Dummy {

  @Id
  private Integer id;

  private String name;
}
