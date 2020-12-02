package com.codegym.service.impl;

import com.codegym.model.TradingCodeBorrowBook;
import com.codegym.repository.TradingCodeBorrowBookRepository;
import com.codegym.service.TradingCodeBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TradingCodeBorrowBookServiceImpl implements TradingCodeBorrowBookService {
    @Autowired
    TradingCodeBorrowBookRepository tradingCodeBorrowBookRepository;
    @Override
    public Page<TradingCodeBorrowBook> findAll(Pageable pageable) {
        return this.tradingCodeBorrowBookRepository.findAll(pageable);
    }

    @Override
    public void create(TradingCodeBorrowBook tradingCodeBorrowBook) {
        this.tradingCodeBorrowBookRepository.save(tradingCodeBorrowBook);
    }

    @Override
    public void deleteById(String id) {
        this.tradingCodeBorrowBookRepository.deleteById(id);

    }

    @Override
    public TradingCodeBorrowBook findById(String id) {
        return this.tradingCodeBorrowBookRepository.findById(id).orElse(null);
    }

}
