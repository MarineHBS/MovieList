package com.example.movielist.ui.addmovie;

import com.example.movielist.models.Movie;
import com.example.movielist.ui.Presenter;

import javax.inject.Inject;

public class AddNewMoviePresenter extends Presenter<AddNewMovieScreen>{
    @Inject
    public AddNewMoviePresenter(){
    }

    @Override
    public void attachScreen(AddNewMovieScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }
    public void saveMovie(
            Movie m) {
        screen.saveMovie(m);
    }
}
