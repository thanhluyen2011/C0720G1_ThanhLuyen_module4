package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService  {

    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);
}
