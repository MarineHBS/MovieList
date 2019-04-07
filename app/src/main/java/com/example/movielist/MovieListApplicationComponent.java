package com.example.movielist;

import com.example.movielist.interactor.movies.MoviesInteractor;
import com.example.movielist.network.NetworkModule;
import com.example.movielist.ui.UIModule;
import com.example.movielist.ui.main.MainActivity;
import com.example.movielist.ui.movies.MoviesFragment;
import com.example.movielist.ui.movies.MoviesPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface MovieListApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MoviesFragment moviesFragment);

    void inject(MoviesInteractor moviesInteractor);

    void inject(MoviesPresenter moviesPresenter);
}
