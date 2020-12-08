package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogRestController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogList = this.blogService.finAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerStudent(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        this.blogService.saveBlog(blog);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api-blog/detail/{id}").buildAndExpand(blog.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getDetailStudent(@PathVariable Integer id) {
        Blog blog = this.blogService.selectBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id) {
        Blog blog = this.blogService.selectBlogById(id);

        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        blog.setTitle(blog.getTitle());
        blog.setWriteDay(blog.getWriteDay());
        blog.setContent(blog.getContent());
        blog.setWriter(blog.getWriter());
        blog.setCategory(blog.getCategory());
        this.blogService.saveBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id){
        Blog blog=this.blogService.selectBlogById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        this.blogService.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
