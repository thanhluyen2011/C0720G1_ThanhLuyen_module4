package com.codegym.service;

import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    List<Blog> findAllScroll(int start, int limit);

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAllBlogOfCategory(String categoryID);

    Blog findById(String id);

    void save(Blog blog);

    void edit(Blog blog);

    void delete(String id);

    Page<Blog> findByNameContaining(Pageable pageable, String name);

    List<Blog> findAllBlogAndSort();
}
