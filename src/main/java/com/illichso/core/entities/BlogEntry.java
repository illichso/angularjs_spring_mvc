package com.illichso.core.entities;

public class BlogEntry {
    private Long id;
    private String title;
    private Blog blog;

    public BlogEntry() {
    }

    public BlogEntry(String title) {
        this.title = title;
    }

    public BlogEntry(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public BlogEntry(Long id, String title, Blog blog) {
        this.id = id;
        this.title = title;
        this.blog = blog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntry that = (BlogEntry) o;

        return !(title != null ? !title.equals(that.title) : that.title != null);

    }

    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    public String toString() {
        return "BlogEntity{" +
                "title='" + title + '\'' +
                '}';
    }
}
