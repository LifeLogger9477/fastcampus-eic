package com.example.aopsandbox.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-03-02
 */
@RestController
public class ProductController {

  private final ProductService productService;
//  private final AlphabetConfigs alphabetConfigs;

  public ProductController(
      ProductService productService
//      AlphabetConfigs alphabetConfigs
  ) {

    this.productService = productService;
//    this.alphabetConfigs = alphabetConfigs;
  }

  @GetMapping(value = "/api/product/shoe")
  public void createShoe() {

//    alphabetConfigs.getGoogle();
    productService.createShoe(new ProductDTO("신발", "shoe"));
  }

  @GetMapping(value = "/api/product/bag")
  public void createBag() {

    productService.createBag(new ProductDTO("가방", "bag"));
  }

  @GetMapping(value = "/api/product/pants")
  public void createPants() {

    productService.createPants(new ProductDTO("바지", "pants"));
  }
}