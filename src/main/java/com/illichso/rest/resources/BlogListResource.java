package com.illichso.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class BlogListResource extends ResourceSupport {
    private List<BlogResource> blogs = new ArrayList<>();

    public List<com.illichso.rest.resources.BlogResource> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<com.illichso.rest.resources.BlogResource> blogs) {
        this.blogs = blogs;
    }
}
