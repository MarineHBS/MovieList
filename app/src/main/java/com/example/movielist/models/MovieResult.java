package com.example.movielist.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResult {

    private Movie movie;

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

    public MovieResult(){

    }

    public Movie createMovie(){
        return new Movie(title, year, genre, rating, description);
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

}
