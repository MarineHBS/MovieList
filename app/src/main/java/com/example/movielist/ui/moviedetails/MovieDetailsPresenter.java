package com.example.movielist.ui.moviedetails;

import com.example.movielist.ui.Presenter;

import javax.inject.Inject;

public class MovieDetailsPresenter extends Presenter<MovieDetailsScreen> {
    @Inject
    public MovieDetailsPresenter(){
    }

    @Override
    public void attachScreen(MovieDetailsScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }

    public void editMovie() {
        screen.editMovie();
    }

    public void deleteMovie(){ screen.deleteMovie();}
}
