package com.codegym.service.Impl;

import com.codegym.model.Blog;
import com.codegym.repository.IRepositoryBlog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IRepositoryBlog iBlogRepository;

    @Override
    public Page<Blog> getAllBlog( Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> finAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog selectBlogById(int id) {
        return iBlogRepository.getOne(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchBlog(String key, Pageable pageable) {
        return iBlogRepository.findBlogByTitleContains(key,pageable);
    }


}
