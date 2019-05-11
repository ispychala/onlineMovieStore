package com.take.movies.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MOVIES")
public class Movie implements Serializable{
    @Column(name = "ID")
    @Id
    private Integer id;

    @Column(name = "TITLE", nullable = false, length = 400)
    private String title;

    @Column(name = "CATEGORY", length = 50)
    private String category;

    @Column(name = "YEAR", length = 4)
    private String year;

    @Column(name = "CAST", length = 4000)
    private String cast;

    @Column(name = "DIRECTOR", length = 4000)
    private String director;

    @Column(name = "STORY", length = 4000)
    private String story;

    @Column(name = "PRICE")
    private float price;

    public Movie() {

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
