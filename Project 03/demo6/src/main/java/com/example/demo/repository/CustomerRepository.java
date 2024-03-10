package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * author : ms.Lee
 * date   : 2024-03-10
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
