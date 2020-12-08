package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAllBlog(Pageable pageable);
    List<Blog> finAll();
    Blog selectBlogById(int id);
    void saveBlog (Blog blog);
    void deleteBlog(int id);
    Page<Blog> searchBlog(String key,Pageable pageable);
}
