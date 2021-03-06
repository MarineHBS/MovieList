package com.example.movielist;

import com.example.movielist.interactor.movies.MovieInteractor;
import com.example.movielist.network.NetworkModule;
import com.example.movielist.ui.UIModule;
import com.example.movielist.ui.addmovie.AddNewMovieActivity;
import com.example.movielist.ui.editmovie.EditMovieActivity;
import com.example.movielist.ui.main.MainActivity;
import com.example.movielist.ui.moviedetails.MovieDetailsActivity;
import com.example.movielist.ui.movies.MoviesFragment;
import com.example.movielist.ui.movies.MoviesPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface MovieListApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(AddNewMovieActivity addNewMovieActivity);

    void inject(EditMovieActivity editMovieActivity);

    void inject(MovieDetailsActivity movieDetailsActivity);

    void inject(MoviesFragment moviesFragment);

    void inject(MovieInteractor movieInteractor);

    void inject(MoviesPresenter moviesPresenter);
}
