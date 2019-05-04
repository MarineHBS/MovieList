package com.example.movielist.models;

import io.swagger.annotations.ApiModel;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Movie extends SugarRecord {

    private Integer movieId = null;

    private String title = null;

    private String description = null;

    private String year = null;

    private String genre = null;

    private String rating = null;

    public Movie(){
        super();
    }

    public Movie(String title, String year, String genre, String rating, String description){
        super();
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
    }

    public Integer getMovieId() {
        return movieId;
    }
    public void setId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
}
