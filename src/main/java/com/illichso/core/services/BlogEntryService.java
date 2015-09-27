package com.illichso.core.services;


import com.illichso.core.entities.BlogEntry;

public interface BlogEntryService {
    BlogEntry find(Long id);

    BlogEntry delete(Long id);

    BlogEntry update(Long id, BlogEntry data);
}
