package com.example.movielist.interactor.movies;

import android.util.Log;
import android.widget.Toast;

import com.example.movielist.MovieListApplication;
import com.example.movielist.interactor.movies.events.GetMovieEvent;
import com.example.movielist.interactor.movies.events.GetMoviesEvent;
import com.example.movielist.model.Movie;
import com.example.movielist.model.MovieResult;
import com.example.movielist.model.MoviesResult;
import com.example.movielist.model.Token;
import com.example.movielist.network.MoviesApi;
import com.example.movielist.network.TokenApi;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

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
    /*
    public void getMovies() {
        GetMoviesEvent event = new GetMoviesEvent();
        try {

            Call<List<Movie>> moviesQueryCall = moviesApi.getMovies();

            Response<List<Movie>> response = moviesQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setMovies(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void getMovieByTitle(String title) {
        GetMovieEvent event = new GetMovieEvent();
        try {

            Call<Movie> movieQueryCall = moviesApi.getMovieByTitle(title);

            Response<Movie> response = movieQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setMovie(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }*/
}