package com.illichso.core.services;

import com.illichso.core.models.entities.BlogEntry;

public interface BlogEntryService {
    BlogEntry findBlogEntry(Long id);
    BlogEntry deleteBlogEntry(Long id);
    BlogEntry updateBlogEntry(Long id, BlogEntry data);

}
