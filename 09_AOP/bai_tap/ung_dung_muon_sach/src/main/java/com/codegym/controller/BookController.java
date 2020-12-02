package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.TradingCodeBorrowBook;
import com.codegym.service.BookService;
import com.codegym.service.TradingCodeBorrowBookService;
import com.codegym.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    TradingCodeBorrowBookService tradingCodeBorrowBookService;
    @GetMapping("/")
    public String goHome(){
        return "home";
    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView goCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("book",new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Book book, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("book",book);
            return "create";
        }
        this.bookService.create(book);
        return "redirect:/";
    }

    @GetMapping("/listBook")
    public String goListBook(@PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("listBook",this.bookService.findAll(pageable));
        return "list_book";
    }

    @GetMapping("/borrow")
    public String goViewBook(@RequestParam Integer id, Model model){
        model.addAttribute("book",this.bookService.findById(id));
        return "view_book";
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Book book,Model model) throws Exception {
        Integer quantity=book.getQuantity()-1;
        book.setQuantity(quantity);
        this.bookService.update(book);
        String idCode=Long.toString(Math.round(Math.random()*100000));
        this.tradingCodeBorrowBookService.create(new TradingCodeBorrowBook(idCode,book));
        model.addAttribute("tradingCode",idCode);
        return "trading_code";
    }

    @GetMapping("/giveBook")
    public String goGiveBook(){
        return "give_book";
    }

    @PostMapping("/giveBook")
    public String giveBook(@RequestParam String id,Model model){
        TradingCodeBorrowBook tradingCodeBorrowBook=this.tradingCodeBorrowBookService.findById(id);
        if (tradingCodeBorrowBook==null){
            model.addAttribute("idCode",id);
            model.addAttribute("message","Not found Code");
            return "give_book";
        }
        tradingCodeBorrowBook.getBook().setQuantity(tradingCodeBorrowBook.getBook().getQuantity()+1);
        this.tradingCodeBorrowBookService.deleteById(id);
        model.addAttribute("message","done give book");
        return "give_book";
    }

    @ExceptionHandler(value = Exception.class)
    public String error(){
        return "errors";
    }
}
