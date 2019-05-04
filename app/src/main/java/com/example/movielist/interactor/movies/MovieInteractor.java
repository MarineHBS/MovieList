package com.example.movielist.interactor.movies;

import com.example.movielist.MovieListApplication;
import com.example.movielist.interactor.movies.events.GetMovieEvent;
import com.example.movielist.models.MovieResult;
import com.example.movielist.network.MoviesApi;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;


public class MovieInteractor {
    MoviesApi moviesApi;

    @Inject
    public MovieInteractor(MoviesApi artistsApi) {
        this.moviesApi = artistsApi;
        MovieListApplication.injector.inject(this);
    }

    public void getMovies(String movieQuery) {
        GetMovieEvent event = new GetMovieEvent();
        try {
            Call<MovieResult> moviesQueryCall = moviesApi.getMovies("4057cbfc", movieQuery);
            Response<MovieResult> response = moviesQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setMovie(response.body().createMovie());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}