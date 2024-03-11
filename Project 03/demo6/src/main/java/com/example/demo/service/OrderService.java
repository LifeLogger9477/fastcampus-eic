package com.example.demo.service;

import com.example.demo.domain.CreateOrder;
import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

/**
 * author : ms.Lee
 * date   : 2024-03-11
 */
@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    
    this.orderRepository = orderRepository;
  }

  public void newOrder(CreateOrder createOrder) {

    Order entity = Order.newOrder(createOrder);
    orderRepository.save(entity);
  }
}
