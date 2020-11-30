package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category selectCategoryById(int id);
    void saveCategory (Category category);
    void deleteCategory(int id);
}
