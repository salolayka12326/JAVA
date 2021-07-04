package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guide {
    public Guide() {
    }

    public Guide(String title, String anons, String full) {
        this.title = title;
        this.anons = anons;
        this.full = full;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title, anons, full;
    private int views;

    public Long getId() {
        return id;
    }

    public String getFull() {
        return full;
    }

    public int getViews() {
        return views;
    }

    public String getAnons() {
        return anons;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
