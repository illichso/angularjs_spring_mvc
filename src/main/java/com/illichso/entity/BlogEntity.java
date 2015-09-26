package com.illichso.entity;

public class BlogEntity {
    private String title;

    public BlogEntity() {
    }

    public BlogEntity(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntity that = (BlogEntity) o;

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
