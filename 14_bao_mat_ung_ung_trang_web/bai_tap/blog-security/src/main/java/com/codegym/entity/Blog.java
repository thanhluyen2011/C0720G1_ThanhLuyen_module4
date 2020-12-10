package com.codegym.entity;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {

    @Id
    private String id;

    @Column(name = "blog_name")
    private String name;

    @Column(name = "date_created")
    private String dateCreated;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    @JsonManagedReference
    private Category category;

    private String content;

    public Blog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
