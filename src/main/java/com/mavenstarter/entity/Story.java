package com.mavenstarter.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Story {

    @GeneratedValue
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String title;
    @Column(length = 1000)
    private String content;
    private Date posted;

    @ManyToOne
    private Blogger blogger;

    private Story() {

    }

    public Story(String title, String content, Date posted, Blogger blogger) {
        this.title = title;
        this.content = content;
        this.posted = posted;
        this.blogger = blogger;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public Blogger getBlogger() {
        return blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }


    @Override
    public String toString() {
        return "Story{" +
                "title='" + title + '\'' +
                '}';
    }
}
