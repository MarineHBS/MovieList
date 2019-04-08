package com.example.movielist.network;



import com.example.movielist.model.Movie;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MoviesApi {

    /**
     * searches movies by title
     * By passing in the appropriate options, you can search for\nthe available movie in the system
     * @param title pass the title of the movie you want to search for
     * @return Call<List<Movie>>
     */

    @GET("movie")
    Call<Movie> getMovieByTitle(
            @Query("title") String title
    );


    /**
     * Deletes a movie
     *
     * @param id Movie id to delete
     * @return Call<Void>
     */

    @DELETE("movie")
    Call<Void> deleteMovieById(
            @Query("id") Long id
    );


    /**
     * returns movies
     * By passing in the appropriate options, you can search for\navailable movie in the system
     * @return Call<List<Movie>>
     */

    @GET("movies")
    Call<List<Movie>> getMovies();



    /**
     * adds a movie item
     * Adds a movie to the system
     * @param movie Movie item to add
     * @return Call<Void>
     */

    @POST("movies")
    Call<Void> addMovie(
            @Body Movie movie
    );


}
