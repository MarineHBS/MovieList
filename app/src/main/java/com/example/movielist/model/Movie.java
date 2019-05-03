package com.example.movielist.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

@ApiModel(description = "")
public class Movie extends SugarRecord<Movie> {

    @SerializedName("id")
    private Integer movieId = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("year")
    private String year = null;

    @SerializedName("genre")
    private String genre = null;

    @SerializedName("rating")
    private String rating = null;

    Movie(){}

    Movie(String title, String year, String genre, String rating, String description){
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
