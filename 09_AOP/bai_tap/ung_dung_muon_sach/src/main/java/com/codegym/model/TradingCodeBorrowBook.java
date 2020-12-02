package com.codegym.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "trading_code_borrow_book")
public class TradingCodeBorrowBook {
    @Id
    String idCode;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    Book book;

    public TradingCodeBorrowBook() {
    }

    public TradingCodeBorrowBook(String idCode, Book book) {
        this.idCode = idCode;
        this.book = book;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}