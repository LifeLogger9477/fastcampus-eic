package com.example.demo.service;

import com.example.demo.domain.CreateCustomer;
import com.example.demo.domain.Customer;
import com.example.demo.domain.dto.CustomerDTO;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    
    this.customerRepository = customerRepository;
  }

  @Transactional
  public CustomerDTO newCustomer(CreateCustomer customer) {

    Customer entity = Customer.newCustomer(customer);
    Customer saved = customerRepository.save(entity);

    // --> Customer 자체를 넘기는 것이 아니라 CustomerDTO로 넘긴다.
    // --> ID 가 넘어가는 것은 보안상의 문제가 될 수도 있다.
    return CustomerDTO.builder()
        .address(saved.getAddress())
        .name(saved.getName())
        .phoneNumber(saved.getPhoneNumber())
        .build();
  }
}
