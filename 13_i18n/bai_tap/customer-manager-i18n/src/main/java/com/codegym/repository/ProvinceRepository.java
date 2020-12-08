package com.codegym.repository;

import com.codegym.entity.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}