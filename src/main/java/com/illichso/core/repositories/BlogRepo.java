package com.illichso.core.repositories;

import com.illichso.core.models.entities.Blog;

import java.util.List;

public interface BlogRepo {
    Blog createBlog(Blog data);
    List<Blog> findAllBlogs();
    Blog findBlog(Long id);
    Blog findBlogByTitle(String title);
    List<Blog> findBlogsByAccount(Long accountId);
}
