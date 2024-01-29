package com.example.demo5;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * author : ms.Lee
 * date   : 2024-01-25
 */
@Entity
public class Member {

  @Id
  @GeneratedValue
  private String id;
}
