package com.example.movielist.ui.editmovie;

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
import com.example.movielist.ui.movies.MoviesActivity;
import com.example.movielist.ui.movies.MoviesPresenter;

import javax.inject.Inject;

public class EditMovieActivity extends Activity implements EditMovieScreen{

    String movieTitle;
    TextInputEditText titleET;
    TextInputEditText descriptionET;
    TextInputEditText yearET;
    Spinner genresSpinner;
    Spinner ratingsSpinner;

    Movie m;

    @Inject
    EditMoviePresenter editMoviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_movie);

        MovieListApplication.injector.inject(this);

        movieTitle = getIntent().getStringExtra("MOVIE_TITLE");

        m = Movie.findWithQuery(Movie.class, "Select * from MOVIE where title = ?", movieTitle).get(0);

        titleET = findViewById(R.id.movie_name_edit_text);
        titleET.setText(m.getTitle());

        descriptionET = findViewById(R.id.movie_description_edit_text);
        descriptionET.setText(m.getDescription());

        yearET = findViewById(R.id.movie_year_edit_text);
        yearET.setText(m.getYear());

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
                                                     editMoviePresenter.editMovie();
                                                 }
                                             }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        editMoviePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        editMoviePresenter.detachScreen();
    }

    @Override
    public void editMovie() {
        m.setTitle(titleET.getText().toString());
        m.setYear(yearET.getText().toString());
        m.setGenre(genresSpinner.getSelectedItem().toString());
        m.setRating(ratingsSpinner.getSelectedItem().toString());
        m.setDescription(descriptionET.getText().toString());
        m.save();
        Intent intent = new Intent(EditMovieActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
