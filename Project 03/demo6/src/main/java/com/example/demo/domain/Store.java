package com.example.demo.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Getter
@Table(name = "stores")
public class Store {
  
  @Id
  private String storeId;

  @Column
  private String name;

  @Column
  private String address;

  @Column
  private String phoneNumber;
  
  @Column
  private ZonedDateTime openAt;
  
  @Column
  private ZonedDateTime closeAt;
}
