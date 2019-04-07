package com.example.movielist.network;

import com.example.movielist.model.MoviesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MoviesApi {
    @GET("search")
    Call<MoviesResult> getMovies(@Header("Authorization") String authorisation,
                                  @Query("q") String artist,
                                  @Query("type") String type,
                                  @Query("offset") int offset,
                                  @Query("limit") int limit);
}

