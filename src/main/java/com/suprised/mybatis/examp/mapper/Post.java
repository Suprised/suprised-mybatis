package com.suprised.mybatis.examp.mapper;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {

    private static final long serialVersionUID = 1150438371726067440L;

    private int id;
    private Date createTime;
    private float score;
    private String content;
    private Blog blog; // ËùÊô²©¿Í

    public Post() {
    }
    
    public Post(int id, float score, String content, Blog blog) {
        this.id = id;
        this.createTime = new Date();
        this.score = score;
        this.content = content;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
