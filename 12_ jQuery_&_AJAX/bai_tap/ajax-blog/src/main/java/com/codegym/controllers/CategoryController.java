package com.codegym.controllers;

import com.codegym.entity.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"", "/category"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String home(Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "");
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/home";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        try {
            this.categoryService.save(category);
            redirectAttributes.addFlashAttribute("message", "Create Complete !");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("message", "Create Failed !");
        }
        return "redirect:/category";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam String id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        this.categoryService.edit(category);
        redirectAttributes.addFlashAttribute("message", "Update Complete !");
        return "redirect:/category";
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam String id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam String id, RedirectAttributes redirectAttributes) {
        this.categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete Complete !");
        return "redirect:/category";
    }
}