package com.example.demo.service;

import com.example.demo.domain.CreateOrder;
import com.example.demo.domain.Order;
import com.example.demo.domain.StoreProduct;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * author : ms.Lee
 * date   : 2024-03-11
 */
@Service
public class OrderService {

  private final OrderRepository orderRepository;
  private final StoreService storeService;

  public OrderService(
      OrderRepository orderRepository, 
      StoreService storeService
  ) {
    
    this.orderRepository = orderRepository;
    this.storeService = storeService;
  }

  public void newOrder(CreateOrder createOrder) {

    /**
     * customer id 가 존재하지 않는 경우에 대한
     * 코드 작성 
     * + 테스트 코드 작성해볼 것
     */
    
    
    // 재고 임시 저장
    List<StoreProduct> storeProducts = new ArrayList<>();
    
    // 재고 데이터 고려할 것
    for (Map.Entry<Integer, Integer> entry : createOrder.getQuantityByProduct().entrySet()) {
      
      Integer productId = entry.getKey();
      Integer buyQuantity = entry.getValue();

      StoreProduct storeProduct = 
          storeService.getStoreProduct(
              createOrder.getStoreId(), 
              productId
          );

      int storeQuantity = storeProduct.getStockQuantity();

      if (buyQuantity > storeQuantity) {

        throw new RuntimeException("재고가 없습니다.");
      }
      
      storeProduct.adjustStockQuantity(buyQuantity);

      storeProducts.add(storeProduct);
    }
    
    Order entity = Order.newOrder(createOrder);
    orderRepository.save(entity);

    // 임시 list 데이터 모두 저장
    storeService.saveAll(storeProducts);
  }
}
