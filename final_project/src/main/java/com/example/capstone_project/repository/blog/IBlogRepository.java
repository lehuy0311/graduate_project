package com.example.capstone_project.repository.blog;

import com.example.capstone_project.model.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContaining(String name, Pageable pageable);
}
