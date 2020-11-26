package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository studentRepository;

    private static Map<Integer, Customer> studentMap;

    static {
        studentMap = new TreeMap<>();
        studentMap.put(242, new Customer(242, "Din", "14/10/2020", 5, 1));
        studentMap.put(742, new Customer(742, "Din1", "14/11/2020", 4, 2));
        studentMap.put(142, new Customer(142, "Din2", "14/12/2020", 9, 0));
    }

    @Override
    public List<Customer> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public void save(Customer student) {
        this.studentRepository.save(student);
    }
}
