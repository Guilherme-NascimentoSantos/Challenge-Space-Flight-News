package br.com.challenge.spaceflightnews.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Article {


    // Attributes

    @Id
    private Integer id;
    private String title;
    private String url;
    private String imageUrl;
    private String newsSite;
    @Column(length = 500)
    private String summary;
    private String publishedAt;
    private String updatedAt;
    private Boolean featured;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_launche")
    private Launche launches;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_event")
    private Event events;

    public Article(Integer id, String title, String url, String imageUrl, String newsSite, String summary, String publishedAt, String updatedAt, Boolean featured, Launche launches, Event events) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.newsSite = newsSite;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.featured = featured;
        this.launches = launches;
        this.events = events;
    }

    public Article() {
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Launche getLaunches() {
        return launches;
    }

    public void setLaunches(Launche launches) {
        this.launches = launches;
    }

    public Event getEvents() {
        return events;
    }

    public void setEvents(Event events) {
        this.events = events;
    }


    // toString

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", newsSite='" + newsSite + '\'' +
                ", summary='" + summary + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", featured=" + featured +
                ", launches=" + launches +
                ", events=" + events +
                '}';
    }
}
