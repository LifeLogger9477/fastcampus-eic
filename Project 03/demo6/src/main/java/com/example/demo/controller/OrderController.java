package com.example.demo.controller;

import com.example.demo.domain.CreateOrder;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * author : ms.Lee
 * date   : 2024-03-11
 */
@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {

    this.orderService = orderService;
  }

  @PostMapping(value = "/api/v1/orders")
  public Response<Void> newOrder() {

    HashMap<Integer, Integer> orderMap = new HashMap<>();
    orderMap.put(1, 5);       // 1번 상품 5개
    orderMap.put(2, 10);      // 2번 상품 10개 주문 가정
    
    orderService.newOrder(
        CreateOrder.builder()
            .customerId(1)
            .quantityByProduct(orderMap)
        .build()
    );
    
    return Response.success(null);
  }
}
