package com.illichso.rest.resources.asm;

import com.illichso.core.services.util.BlogList;
import com.illichso.rest.mvc.BlogController;
import com.illichso.rest.resources.BlogListResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm()
    {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}