package com.example.movielist.test;

import com.example.movielist.models.Movie;
import com.example.movielist.ui.movies.MoviesPresenter;
import com.example.movielist.ui.movies.MoviesScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class MoviesTest {
    @Inject
    MoviesPresenter moviesPresenter;
    private MoviesScreen moviesScreen;

    @Before
    public void setup() {
        // DaggerTestComponent injector = setTestInjector();
        //injector.inject(this);
        moviesScreen = mock(MoviesScreen.class);
        moviesPresenter.attachScreen(moviesScreen);
    }

    @Test
    public void testMovies() {
        String query = "Shawshank redemption";
        moviesPresenter.refreshMovies(query);

        ArgumentCaptor<Movie> moviesCaptor = ArgumentCaptor.forClass(Movie.class);
        verify(moviesScreen).showMovie(moviesCaptor.capture());
        assertTrue(moviesCaptor.getValue().getTitle().equals("Shawshank redemption"));
    }


    @After
    public void tearDown() {
        moviesPresenter.detachScreen();
    }
}
