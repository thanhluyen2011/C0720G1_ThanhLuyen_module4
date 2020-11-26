package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);
}
