package com.example.movielist.interactor.movies.events;

import com.example.movielist.models.Movie;

public class GetMovieEvent {
    private int code;
    private Movie movie;
    private Throwable throwable;

    public GetMovieEvent() {
    }

    public GetMovieEvent(int code, Movie movie, Throwable throwable) {
        this.code = code;
        this.movie = movie;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}