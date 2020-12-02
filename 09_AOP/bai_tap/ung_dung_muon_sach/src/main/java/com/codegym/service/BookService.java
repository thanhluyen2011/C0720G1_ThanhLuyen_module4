package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    void update(Book book) throws Exception;
    void create(Book book);
    Book findById(Integer id);
}
