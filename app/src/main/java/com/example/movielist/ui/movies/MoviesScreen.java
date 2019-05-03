package com.example.movielist.ui.movies;

import com.example.movielist.model.Movie;

import java.util.List;

public interface MoviesScreen {
    void showMovies(List<Movie> movies);

    void showMovie(Movie movie);

    void showNetworkError(String errorMsg);
}
