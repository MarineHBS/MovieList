package com.example.movielist.ui.movies;

import com.example.movielist.models.Movie;

import java.util.List;

public interface MoviesScreen {
    void showMovies();

    void showMovie(Movie movie);

    void showNetworkError(String errorMsg);
}
