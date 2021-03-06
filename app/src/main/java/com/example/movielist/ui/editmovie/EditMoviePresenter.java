package com.example.movielist.ui.editmovie;

import com.example.movielist.ui.Presenter;
import com.example.movielist.ui.main.MainScreen;

import javax.inject.Inject;

public class EditMoviePresenter extends Presenter<EditMovieScreen> {

    @Inject
    public EditMoviePresenter(){
    }

    @Override
    public void attachScreen(EditMovieScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }

    public void editMovie() {
        screen.editMovie();
    }
}
