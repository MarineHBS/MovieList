package com.example.movielist.network;

import com.example.movielist.models.MovieResult;

import retrofit2.Call;
import retrofit2.http.*;

public interface MoviesApi {
    @GET(" ")
    Call<MovieResult> getMovies(@Query("apikey") String key,
                                @Query("t") String title);


}
