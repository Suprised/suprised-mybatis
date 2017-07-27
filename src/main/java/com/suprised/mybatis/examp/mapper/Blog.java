package com.suprised.mybatis.examp.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * 博客
 */
public class Blog implements Serializable {

    private static final long serialVersionUID = 3391649189988936698L;

    private int id;
    private String title;
    private Author author;// 作者
    private List<Post> posts; // 文章

    public Blog() {
    }
    
    public Blog(int id) {
        this.id = id;
    }

    public Blog(String title) {
        this.title = title;
    }

    public Blog(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return String.format("id: %s, title: %s", id, title);
    }

}
