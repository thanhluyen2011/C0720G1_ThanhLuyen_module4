package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping({"","/list"})
    public String goHome (Model model) {
        model.addAttribute("list", iBlogService.getAllBlog());
        return "list";
    }
    @GetMapping ("/blog/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "save";
    }
    @PostMapping("/blog/save-new-blog")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        LocalDate date = LocalDate.now();
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Save blog successful");
        return "redirect:/list";
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
        return "redirect:/list";
    }

    @GetMapping("/blog/delete")
    public String deleteBlog(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        iBlogService.deleteBlog(deleteId);
        redirectAttributes.addFlashAttribute("message" , "Delete Blog Successful!");
        return "redirect:/list";
    }
    @GetMapping("/search")
    public String searchBlog(@RequestParam String searchData, Model model) {
        List<Blog> blogList = iBlogService.searchBlog(searchData);
        model.addAttribute("list", blogList);
        model.addAttribute("message", "There are "+blogList.size()+" result(s) found");
        return "list";
    }
}
