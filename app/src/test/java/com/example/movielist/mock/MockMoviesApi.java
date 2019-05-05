package com.example.movielist.mock;

import com.example.movielist.models.Movie;
import com.example.movielist.models.MovieResult;
import com.example.movielist.network.MoviesApi;


import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockMoviesApi implements MoviesApi {
    @Override
    public Call<MovieResult> getMovies(String key, String title) {
        final MovieResult movieResult = new MovieResult();
        Movie movie = new Movie();

        movie.setTitle("Shawshank redemption");
        movie.setDescription("Very good movie");
        movie.setRating("8.8");
        movie.setGenre("drama");
        movie.setYear("1994");

        movieResult.setMovie(movie);

        Call<MovieResult> call = new Call<MovieResult>() {
            @Override
            public Response<MovieResult> execute() throws IOException {
                return Response.success(movieResult);
            }

            @Override
            public void enqueue(Callback<MovieResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<MovieResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }
}
