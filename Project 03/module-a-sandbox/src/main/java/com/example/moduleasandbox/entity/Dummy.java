package com.example.moduleasandbox.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * author : ms.Lee
 * date   : 2024-03-06
 */
@Getter
@Setter
public class Dummy {
  
  @Id
  private Integer id;
  
  private String name;
}
