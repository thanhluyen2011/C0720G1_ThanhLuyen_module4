package com.codegym.service.impl;

import com.codegym.entity.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllScroll(int start, int limit) {
        return this.blogRepository.findAllScroll(start, limit);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBlogOfCategory(String categoryID) {
        List<Blog> blogListResult = new ArrayList<>();
        List<Blog> blogList = this.blogRepository.findAll();
        for (Blog blog : blogList) {
            if (blog.getCategory().getId().equals(categoryID)) {
                blogListResult.add(blog);
            }
        }
        return blogListResult;
    }

    @Override
    public Blog findById(String id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void edit(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void delete(String id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByNameContaining(Pageable pageable, String name) {
        return this.blogRepository.findByNameContaining(pageable, name);
    }

    @Override
    public List<Blog> findAllBlogAndSort() {
        return this.blogRepository.findAllBlogAndSort();
    }
}
