package com.example.movielist.test;

import com.example.movielist.ui.main.MainPresenter;
import com.example.movielist.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import javax.inject.Inject;

import static com.example.movielist.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class MainTest {
    @Inject
    MainPresenter mainPresenter;

    private MainScreen mainScreen;

    @Before
    public void setup() {
        /*DaggerTestComponent injector = setTestInjector();
        injector.inject(this);*/
        mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testSearch() {
        String movie = "Shawshank redemption";
        mainPresenter.showMoviesSearchList(movie);
        verify(mainScreen).showMovies(movie);
    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
