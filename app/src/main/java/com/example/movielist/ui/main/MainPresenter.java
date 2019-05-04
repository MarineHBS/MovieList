package com.example.movielist.ui.main;

import com.example.movielist.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    public MainPresenter(){
    }

    @Override
    public void attachScreen(MainScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }

    public void showMoviesSearchList(
            String movieSearchTerm) {
        screen.showMovies(movieSearchTerm);
    }

    public void showMovies() {
        screen.showPersistedMovies();
    }
}
