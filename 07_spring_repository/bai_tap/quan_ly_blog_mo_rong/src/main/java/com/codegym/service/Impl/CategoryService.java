package com.codegym.service.Impl;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.IRepositoryCategory;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private IRepositoryCategory iRepositoryCategory;
    @Override
    public List<Category> findAll() {
        return iRepositoryCategory.findAll();
    }

    @Override
    public Category selectCategoryById(int id) {
        return iRepositoryCategory.getOne(id);
    }

    @Override
    public void saveCategory(Category category) {
        iRepositoryCategory.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        iRepositoryCategory.deleteById(id);
    }
}
