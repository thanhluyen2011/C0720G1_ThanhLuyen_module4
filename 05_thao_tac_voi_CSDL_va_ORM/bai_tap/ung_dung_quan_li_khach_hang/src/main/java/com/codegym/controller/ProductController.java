package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"","/list"})
    public String index(Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("products",productService.getAll());
        redirectAttributes.addFlashAttribute("message","");
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product,RedirectAttributes redirect){
        product.setId((int)(Math.random()*1000));
        productService.save(product);
        redirect.addFlashAttribute("message","more success");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("message","successfully updated !");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("/customer/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("message", "deleted successfully!");
        return "redirect:/";
    }
}