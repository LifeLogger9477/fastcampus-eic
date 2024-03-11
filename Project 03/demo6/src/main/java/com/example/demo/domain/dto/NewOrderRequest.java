package com.example.demo.domain.dto;

import lombok.Getter;

import java.util.Map;

/**
 * author : ms.Lee
 * date   : 2024-03-11
 */
@Getter
public class NewOrderRequest {

  private final Integer customerId;
  private final Integer storeId;
  private final Map<Integer, Integer> products;


  public NewOrderRequest(
      Integer customerId, 
      Integer storeId, 
      Map<Integer, Integer> products
  ) {
    
    this.customerId = customerId;
    this.storeId = storeId;
    this.products = products;
  }
}
