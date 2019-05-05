package com.example.movielist;

import com.example.movielist.mock.MockNetworkModule;
import com.example.movielist.test.MainTest;
import com.example.movielist.test.MoviesTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends MovieListApplicationComponent{
    void inject(MainTest mainTest);

    void inject(MoviesTest artistsTest);
}
