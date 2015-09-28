package com.illichso.core.services.util;

import com.illichso.core.entities.BlogEntry;

import java.util.ArrayList;
import java.util.List;

public class BlogEntryList {
    private List<BlogEntry> entries = new ArrayList<>();
    private Long blogId;

    public List<BlogEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<BlogEntry> entries) {
        this.entries = entries;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}
