package com.illichso.core.services.util;

import com.illichso.core.entities.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogList {
    private List<Blog> blogs = new ArrayList<>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
