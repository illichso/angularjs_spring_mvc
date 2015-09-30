package com.illichso.core.repositories;

import com.illichso.core.models.entities.BlogEntry;

import java.util.List;

public interface BlogEntryRepo {
    BlogEntry findBlogEntry(Long id);
    BlogEntry deleteBlogEntry(Long id);
    BlogEntry updateBlogEntry(Long id, BlogEntry data);
    BlogEntry createBlogEntry(BlogEntry data);
    List<BlogEntry> findByBlogId(Long blogId);
}
