package com.example.demo.repository;

import com.example.demo.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * author : ms.Lee
 * date   : 2024-03-11
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
  
  
}
