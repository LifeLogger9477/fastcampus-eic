package com.example.demo.controller;

import com.example.demo.domain.CreateCustomer;
import com.example.demo.domain.dto.CustomerDTO;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@RestController
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {

    this.customerService = customerService;
  }

  @PostMapping(value = "/api/v1/customers")
  public Response<CustomerDTO> createNewCustomer(
      @RequestParam String name, 
      @RequestParam String address, 
      @RequestParam String phoneNumber
  ) {

    return Response.success(customerService.newCustomer(
        CreateCustomer.builder()
            .address(address)
            .name(name)
            .phoneNumber(phoneNumber)
            .build()
        )
    );
  }
}
