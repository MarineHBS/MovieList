package com.example.movielist.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResult {


    @SerializedName("Title")
    @Expose
    public String title;

    @SerializedName("Year")
    @Expose
    public String year;

    @SerializedName("Genre")
    @Expose
    public String genre;

    @SerializedName("imdbRating")
    @Expose
    public String rating;

    @SerializedName("Plot")
    @Expose
    public String description;

    public Movie createMovie(){
        return new Movie(title, year, genre, rating, description);
    }

/*
    @SerializedName("movie")
    @Expose
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }*/
}
