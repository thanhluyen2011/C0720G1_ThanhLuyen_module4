package com.codegym.repository;

import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, String> {
    Page<Blog> findByNameContaining(Pageable pageable, String name);

    @Query(value = "select * from blog group by id order by date_created desc", nativeQuery = true)
    List<Blog> findAllBlogAndSort();

    @Query(value = "select * from blog limit  ?1, ?2", nativeQuery = true)
    List<Blog> findAllScroll(int start, int limit);
}