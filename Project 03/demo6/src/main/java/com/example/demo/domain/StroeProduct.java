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
@Table(name = "store_products")
public class StroeProduct {
  
  @Id
  private String storeProductId;
  
  @Column
  private String stroeId;
  
  @Column
  private String productId;
  
  @Column
  private String stockQuantity;
}
