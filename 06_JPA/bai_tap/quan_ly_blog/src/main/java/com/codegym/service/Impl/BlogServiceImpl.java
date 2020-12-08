package com.codegym.service.Impl;

import com.codegym.model.Blog;
import com.codegym.repository.IRepositoryBlog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IRepositoryBlog iBlogRepository;
    private PagingAndSortingRepository pagingAndSortingRepository;
    @Override
    public List<Blog> getAllBlog() {
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
    public List<Blog> searchBlog(String searchData) {
        return iBlogRepository.findAllByTitle(searchData);
    }

}
