package com.codegym.model;

import lombok.*;

import javax.persistence.*;


@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Column(name = "write_day", columnDefinition = "DATE")
    private String writeDay;
    private String writer;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id",nullable = false)
    private Category category;

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getWriteDay() {
        return writeDay;
    }

    public void setWriteDay(String writeDay) {
        this.writeDay = writeDay;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
