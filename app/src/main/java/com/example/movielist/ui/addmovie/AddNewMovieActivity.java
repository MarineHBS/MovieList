package com.example.movielist.ui.addmovie;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;

import com.example.movielist.MovieListApplication;
import com.example.movielist.R;
import com.example.movielist.models.Movie;
import com.example.movielist.ui.main.MainActivity;
import com.example.movielist.ui.movies.MoviesPresenter;

import javax.inject.Inject;

public class AddNewMovieActivity extends Activity implements AddNewMovieScreen{
    @Inject
    AddNewMoviePresenter addNewMoviePresenter;

    TextInputEditText titleET;
    TextInputEditText descriptionET;
    TextInputEditText yearET;
    Spinner genresSpinner;
    Spinner ratingsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_movie);

        MovieListApplication.injector.inject(this);

        titleET = findViewById(R.id.movie_name_edit_text);

        descriptionET = findViewById(R.id.movie_description_edit_text);

        yearET = findViewById(R.id.movie_year_edit_text);

        genresSpinner = findViewById(R.id.genres_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genres_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genresSpinner.setAdapter(adapter);

        ratingsSpinner = findViewById(R.id.ratings_spinner);
        ArrayAdapter<CharSequence> adapter_ = ArrayAdapter.createFromResource(this,
                R.array.ratings_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ratingsSpinner.setAdapter(adapter_);

        Button addNewMovieButton = findViewById(R.id.add_new_movie_button);
        addNewMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie m = new Movie(titleET.getText().toString(), yearET.getText().toString(),
                        genresSpinner.getSelectedItem().toString(),
                        ratingsSpinner.getSelectedItem().toString(), descriptionET.getText().toString());
                addNewMoviePresenter.saveMovie(m);
            }
        }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        addNewMoviePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        addNewMoviePresenter.detachScreen();
    }

    @Override
    public void saveMovie(Movie m) {
        m.save();
        Intent intent = new Intent(AddNewMovieActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
