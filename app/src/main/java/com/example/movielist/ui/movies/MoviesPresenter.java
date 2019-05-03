package com.example.movielist.ui.movies;

import com.example.movielist.di.Network;
import com.example.movielist.interactor.movies.MovieInteractor;
import com.example.movielist.interactor.movies.events.GetMovieEvent;
import com.example.movielist.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MoviesPresenter extends Presenter<MoviesScreen> {
    Executor networkExecutor;
    MovieInteractor movieInteractor;

    @Inject
    public MoviesPresenter(@Network Executor networkExecutor, MovieInteractor movieInteractor) {
        this.networkExecutor = networkExecutor;
        this.movieInteractor = movieInteractor;
    }

    @Override
    public void attachScreen(MoviesScreen screen) {
        EventBus.getDefault().register(this);
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();

    }

    public void refreshMovies(final String moviesQuery) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                movieInteractor.getMovies(moviesQuery);
            }
        });
    }

    /*@Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetMoviesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showMovies(event.getMovies());
            }
        }
    }*/

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetMovieEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showMovie(event.getMovie());
            }
        }
    }

}
