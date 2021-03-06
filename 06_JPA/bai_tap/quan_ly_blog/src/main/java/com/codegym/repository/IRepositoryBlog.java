package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.debugger.Page;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

@Repository
public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByTitle(String searchData);
}
