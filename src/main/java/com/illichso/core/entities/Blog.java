package com.illichso.core.entities;

public class Blog {
    private Long id;
    private String title;
    private Account owner;

    public Blog() {
    }

    public Blog(Long id, String title, Account owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
