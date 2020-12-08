package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {
    Page<Blog> findBlogByTitleContains(String key, Pageable pageable);

}
