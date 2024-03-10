package com.example.demo.domain.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Getter
@Builder
public class CustomerDTO {
  
  private final String name;
  private final String address;
  private final String phoneNumber;
}
