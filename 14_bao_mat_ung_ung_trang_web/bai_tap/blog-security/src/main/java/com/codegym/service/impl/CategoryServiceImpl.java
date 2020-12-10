package com.codegym.service.impl;

import com.codegym.entity.Category;
import com.codegym.repository.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void edit(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(String id) {
        this.categoryRepository.deleteById(id);
    }
}
