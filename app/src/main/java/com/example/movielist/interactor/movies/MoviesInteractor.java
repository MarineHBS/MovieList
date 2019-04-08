package com.example.movielist.interactor.movies;

import com.example.movielist.MovieListApplication;
import com.example.movielist.interactor.movies.events.GetMovieEvent;
import com.example.movielist.interactor.movies.events.GetMoviesEvent;
import com.example.movielist.model.Movie;
import com.example.movielist.model.MoviesResult;
import com.example.movielist.model.Token;
import com.example.movielist.network.MoviesApi;
import com.example.movielist.network.TokenApi;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.movielist.network.NetworkConfig.AUTH_PREFIX;
import static com.example.movielist.network.NetworkConfig.TOKEN_AUTHORISATION;
import static com.example.movielist.network.NetworkConfig.TOKEN_CLIENT_CREDENTIALS;

public class MoviesInteractor {
    MoviesApi moviesApi;

    @Inject
    public MoviesInteractor(MoviesApi moviesApi) {
        this.moviesApi = moviesApi;
        MovieListApplication.injector.inject(this);
    }

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
    }
}
