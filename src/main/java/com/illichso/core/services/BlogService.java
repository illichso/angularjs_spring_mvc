package com.illichso.core.services;

import com.illichso.core.entities.Blog;
import com.illichso.core.entities.BlogEntry;
import com.illichso.core.services.util.BlogEntryList;
import com.illichso.core.services.util.BlogList;

public interface BlogService {
    BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    BlogList findAllBlogs();

    BlogEntryList findAllBlogEntries(Long blogId); // findBlog all associated blog entries

    Blog findBlog(Long id);
}
