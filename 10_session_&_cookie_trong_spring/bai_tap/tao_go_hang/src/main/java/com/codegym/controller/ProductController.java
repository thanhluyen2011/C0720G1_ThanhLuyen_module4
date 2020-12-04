package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cartList")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cartList")
    public List<Product> setUpCart(){
        return new ArrayList<>();
    }
    @GetMapping("/product")
    public String getHome(Model model){
        model.addAttribute("productList",productService.findAll());
        return "home";
    }
    @GetMapping("/product/view/{id}")
    public String getView(Model model, @PathVariable Integer id){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }
    @GetMapping("/product/borrow/{id}")
    public String getCart(@ModelAttribute(value = "cartList") List<Product> list, Model model, @PathVariable Integer id,
                          RedirectAttributes redirect){
        Product product = productService.findById(id);
        product.setQuantity(product.getQuantity()-1);
        productService.save(product);
        product.setQuantity(1);
        list.add(product);
        return "redirect:/product";
    }
    @GetMapping("/cartList")
    public String getListCart(Model model){
        return "cartList";
    }
    @GetMapping("/cartList/delete/{id}")
    public String deleteCartList(@ModelAttribute(value = "cartList") List<Product> list, Model model, @PathVariable Integer id){
        for (Product product : list){
            if (product.getId()==id){
                list.remove(product);
                break;
            }
        }
        Product product = productService.findById(id);
        product.setQuantity(product.getQuantity()+1);
        productService.save(product);
        return "redirect:/product";
    }
}
