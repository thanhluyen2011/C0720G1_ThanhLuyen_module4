package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping({"","/list"})
    public String goHome (Model model,
                          @PageableDefault(size = 2) Pageable pageable,
                          @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";
        if (!keyword.isPresent()){
            model.addAttribute("listBlog", iBlogService.getAllBlog(pageable));
        }else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("listBlog", iBlogService.searchBlog(keywordAfterCheck,pageable));
        }
        model.addAttribute("keyword",keywordAfterCheck);
        return "home";
    }
    @GetMapping("/blog/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "save";
    }
    @PostMapping("/blog/save-new-blog")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        LocalDate date = LocalDate.now();
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Save blog successful");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/view")
    public String readBlock(@PathVariable int id, Model model) {
        model.addAttribute("blog",iBlogService.selectBlogById(id));
        return "view";
    }
    @GetMapping("/blog/edit/{id}")
    public String editBlog(@PathVariable int id, Model model){
        model.addAttribute("blog", iBlogService.selectBlogById(id));
        return "edit";
    }
    @PostMapping("/blog/save-blog")
    public String saveOldBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Save blog successful");
        return "redirect:/";
    }

    @GetMapping("/blog/delete")
    public String deleteBlog(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iBlogService.deleteBlog(deleteId);
        redirectAttributes.addFlashAttribute("message" , "Delete Blog Successful!");
        return "redirect:/ ";
    }
    @GetMapping("/category/list")
    public String listCategory(Model model) {
        model.addAttribute("listCategory",categoryService.findAll());
        return "listCategory";
    }
    @GetMapping("/category/delete")
    public String deleteCateGory(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        categoryService.deleteCategory(deleteId);
        redirectAttributes.addFlashAttribute("message", "Delete Category Successful!");
        return "redirect:/category/list ";
    }
    @GetMapping("/category/create")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "saveCategory";
}
    @PostMapping("/category/save-category")
    public String saveOldCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message", "Save category successful");
        return "redirect:/category/list";
    }
    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable int id, Model model){
        model.addAttribute("category",categoryService.selectCategoryById(id));
        return "editCategory";
    }
}
