package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Getter
@Builder
public class CreateOrder {
  
  private int customerId;
  private int storeId;
  private Map<Integer, Integer> quantityByProduct;  // ["아메리카노", 3]
}
