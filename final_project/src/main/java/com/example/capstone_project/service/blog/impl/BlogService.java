package com.example.capstone_project.service.blog.impl;

import com.example.capstone_project.model.blog.Blog;
import com.example.capstone_project.repository.blog.IBlogRepository;
import com.example.capstone_project.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public Page<Blog> getBlog(String name,Pageable pageable) {
        return this.iBlogRepository.findAllByTitleContaining(name,pageable);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.iBlogRepository.findById(id).get();
    }
}
