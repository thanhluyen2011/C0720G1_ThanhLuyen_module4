package com.codegym.repository;

import com.codegym.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository  extends JpaRepository<Category, String> {
    @Query(value = "select * from category where category_name like concat('%', ?1, '%')", nativeQuery = true)
    Category findByName(String nameNeedFind);
}
