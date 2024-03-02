package com.example.aopsandbox.product;

import org.springframework.stereotype.Service;

/**
 * author : ms.Lee
 * date   : 2024-03-02
 */
@Service
public class ProductService {

  public void createShoe(ProductDTO dto) {

    System.out.println("신발 만들기");
  }

  public void createBag(ProductDTO dto) {

    System.out.println("가방 만들기");
  }

  public void createPants(ProductDTO dto) {

    System.out.println("바지 만들기");
  }
}
