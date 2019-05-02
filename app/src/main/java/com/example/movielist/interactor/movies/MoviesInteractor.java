package com.example.movielist.interactor.movies;

import com.example.movielist.MovieListApplication;
import com.example.movielist.interactor.movies.events.GetMoviesEvent;
import com.example.movielist.model.MoviesResult;
import com.example.movielist.model.Token;
import com.example.movielist.network.MoviesApi;
import com.example.movielist.network.TokenApi;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;


public class MoviesInteractor {
    MoviesApi moviesApi;

    @Inject
    public MoviesInteractor(MoviesApi artistsApi) {
        this.moviesApi = artistsApi;
        MovieListApplication.injector.inject(this);
    }

    public void getMovies(String movieQuery) {
        GetMoviesEvent event = new GetMoviesEvent();
        try {

            Call<MoviesResult> moviesQueryCall = moviesApi.getMovies(movieQuery, "movie", 0, 3);

            Response<MoviesResult> response = moviesQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setMovies(response.body().getMovies());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }

    }
}
