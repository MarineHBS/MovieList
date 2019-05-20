package com.example.movielist.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.example.movielist.MovieListApplication;
import com.example.movielist.R;
import com.example.movielist.models.Movie;
import com.example.movielist.ui.movies.MoviesActivity;

import java.util.List;

import javax.inject.Inject;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;



public class MainActivity extends AppCompatActivity implements MainScreen {
    public static final String KEY_MOVIES = "KEY_MOVIES";
    @Inject
    MainPresenter mainPresenter;
    private EditText etMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());
        //Movie m = Movie.last(Movie.class);
        //Log.v("movieinmain", "movie titel: " + m.getTitle());

        MovieListApplication.injector.inject(this);

        etMovies = findViewById(R.id.etMovie);

        Button btnShowMovies = findViewById(R.id.btnShowMovies);
        btnShowMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.showMoviesSearchList(etMovies.getText().toString());
            }
        });
        Button btnShowPersistedMovies = findViewById(R.id.btnShowPersistedMovies);
        btnShowPersistedMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.showMovies();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMovies(String movieSearchTerm) {
        Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
        intent.putExtra(KEY_MOVIES, movieSearchTerm);
        startActivity(intent);
    }
    @Override
    public void showPersistedMovies() {
        Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
        intent.putExtra(KEY_MOVIES, "showPersistedMovies");
        startActivity(intent);
    }
}