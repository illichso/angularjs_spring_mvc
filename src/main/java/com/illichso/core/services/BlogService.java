package com.illichso.core.services;

import com.illichso.core.models.entities.Blog;
import com.illichso.core.models.entities.BlogEntry;
import com.illichso.core.services.util.BlogEntryList;
import com.illichso.core.services.util.BlogList;
public interface BlogService {
    BlogEntry createBlogEntry(Long blogId, BlogEntry data);
    BlogList findAllBlogs();
    BlogEntryList findAllBlogEntries(Long blogId);
    Blog findBlog(Long id);
}