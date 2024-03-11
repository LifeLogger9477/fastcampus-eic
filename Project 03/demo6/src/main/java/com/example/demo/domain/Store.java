package com.example.demo.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Getter
@Table(name = "stores")
public class Store {
  
  @Id
  private int storeId;

  @Column
  private String name;

  @Column
  private String address;

  @Column
  private String phoneNumber;
  
  @Column
  private String openAt;
  
  @Column
  private String closeAt;
}
