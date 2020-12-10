package com.codegym.controllers;

import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String home(Model model, RedirectAttributes redirectAttributes, @PageableDefault(size = 2) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        redirectAttributes.addFlashAttribute("message", "");

        String keywordOld = "";
        if (keyword.isPresent()) {
            keywordOld = keyword.get();
            model.addAttribute("blogList", blogService.findByNameContaining(pageable, keywordOld));
        } else {
            model.addAttribute("blogList", blogService.findAll(pageable));
        }
        model.addAttribute("keywordOld", keywordOld);

        return "blog/home";
    }

    @GetMapping("/blog-of-category")
    public String blogOfCategory(Model model, @RequestParam String id) {
        model.addAttribute("blogList", blogService.findAllBlogOfCategory(id));
        return "blog/blog-of-category";
    }

    @GetMapping("/sort")
    public String sortBlogByDateCreate(Model model) {
        model.addAttribute("blogList", blogService.findAllBlogAndSort());
        return "blog/sort-blog";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", this.categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        try {
            this.blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "Create Complete !");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("message", "Create Failed !");
        }
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String viewBlog(@RequestParam String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", this.categoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.edit(blog);
        redirectAttributes.addFlashAttribute("message", "Update Complete !");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam String id, RedirectAttributes redirectAttributes) {
        this.blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete Complete !");
        return "redirect:/blog";
    }
}