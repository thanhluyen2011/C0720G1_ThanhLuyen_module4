package com.codegym.service;

import com.codegym.model.TradingCodeBorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TradingCodeBorrowBookService {
    Page<TradingCodeBorrowBook> findAll(Pageable pageable);
    void create(TradingCodeBorrowBook tradingCodeBorrowBook);
    void deleteById(String id);
    TradingCodeBorrowBook findById(String id);
}
