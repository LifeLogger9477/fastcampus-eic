package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Getter
@Builder
public class CreateCustomer {   // 편리하게 사용하기 위해서
  
  private final String name;
  private final String address;
  private final String phoneNumber;
}
