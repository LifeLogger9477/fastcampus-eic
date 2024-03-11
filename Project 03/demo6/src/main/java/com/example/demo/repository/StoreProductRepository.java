package com.example.demo.repository;

import com.example.demo.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * author : ms.Lee
 * date   : 2024-03-11
 */
public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {

  // 특정 조건에 따라 데이터를 가지고 와야 한다.
  Optional<StoreProduct> findByStoreIdAndProductId(int storeId, int productId);
}
