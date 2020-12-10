package com.codegym.controllers;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@Controller
@RequestMapping("/restBlog")
@CrossOrigin
public class RestBlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<String>> getListCategory() {
        List<Category> categoryList = this.categoryService.findAll();
        List<String> categoryName = new ArrayList<>();
        for (Category category : categoryList) {
            categoryName.add(category.getName());
        }
        return new ResponseEntity<>(categoryName, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<String>> getListBlog() {
        List<Blog> blogList = this.blogService.findAll();
        List<String> blogName = new ArrayList<>();
        for (Blog blog : blogList) {
            blogName.add(blog.getName());
        }
        return new ResponseEntity<>(blogName, HttpStatus.OK);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<String>> getCategory(@PathVariable String name) {
        Category category = this.categoryService.findByName(name);
        List<Blog> blogList = this.blogService.findAll();
        List<String> blogNameOfCategory = new ArrayList<>();
        for (Blog blog : blogList) {
            if (blog.getCategory().getId().equals(category.getId())) {
                blogNameOfCategory.add(blog.getName());
            }
        }
        return new ResponseEntity<>(blogNameOfCategory, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable String id) {
        Blog blog = this.blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/ajax-blog")
    public ResponseEntity<List<Blog>> getListBlogAjax() {
        List<Blog> blogList = this.blogService.findAll();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/ajax-blog-scroll")
    public ResponseEntity<List<Blog>> getListBlogAjaxScroll(@RequestParam int start, int limit) {
        List<Blog> blogList = this.blogService.findAllScroll(start, limit);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}