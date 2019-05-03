package com.example.movielist;

import android.app.Application;

import com.example.movielist.ui.UIModule;

public class MovieListApplication extends Application {

    public static MovieListApplicationComponent injector;

    @Override
    public void onCreate(){
        super.onCreate();

        injector = DaggerMovieListApplicationComponent.builder().
                uIModule(
                        new UIModule(this)
                ).build();

    }
}
