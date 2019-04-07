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

import static com.example.movielist.network.NetworkConfig.AUTH_PREFIX;
import static com.example.movielist.network.NetworkConfig.TOKEN_AUTHORISATION;
import static com.example.movielist.network.NetworkConfig.TOKEN_CLIENT_CREDENTIALS;

public class MoviesInteractor {
    MoviesApi moviesApi;
    TokenApi tokenApi;

    @Inject
    public MoviesInteractor(MoviesApi artistsApi, TokenApi tokenApi) {
        this.moviesApi = artistsApi;
        this.tokenApi = tokenApi;
        MovieListApplication.injector.inject(this);
    }

    public void getMovies(String movieQuery) {
        /*
        Call<Token> tokenQueryCAll = tokenApi.getToken(TOKEN_CLIENT_CREDENTIALS, TOKEN_AUTHORISATION);

        GetMoviesEvent event = new GetMoviesEvent();
        try {
            Response<Token> tokenResponse = tokenQueryCAll.execute();
            String authToken = AUTH_PREFIX + tokenResponse.body().getAccessToken();

            Call<MoviesResult> moviesQueryCall = moviesApi.getMovies(authToken, movieQuery, "movie", 0, 3);

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
        */
    }
}
