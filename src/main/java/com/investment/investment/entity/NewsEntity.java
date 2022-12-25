package com.investment.investment.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "news")
public class NewsEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "headline")
    private String headline;

    @Column(name = "description")
    @Size(max = 4000)
    private String description;

    @Column(name = "linkImage")
    private String linkImage;

    public NewsEntity(String headline, String description, String linkImage) {
        this.headline = headline;
        this.description = description;
        this.linkImage = linkImage;
    }

    public NewsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }
}
