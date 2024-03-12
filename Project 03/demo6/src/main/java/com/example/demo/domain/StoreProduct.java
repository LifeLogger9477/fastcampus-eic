package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Getter
@Builder
@Table(name = "store_products")
public class StoreProduct {
  
  @Id
  private int storeProductId;
  
  @Column
  private int storeId;
  
  @Column
  private int productId;
  
  @Column
  private int stockQuantity;

  public void adjustStockQuantity(int buyQuantity) {

    // 안전상의 이유로 추가
    if (stockQuantity < buyQuantity) {

      throw new RuntimeException("재고보다 많을 수 없습니다.");
    }

    this.stockQuantity = this.stockQuantity - buyQuantity;
  }
}
