package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.BookRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public void update(Book book) throws Exception {
        if (book.getQuantity()==-1){
            throw new Exception();
        }
        this.bookRepository.save(book);
    }

    @Override
    public void create(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return this.bookRepository.findById(id).orElse(null);
    }
}
