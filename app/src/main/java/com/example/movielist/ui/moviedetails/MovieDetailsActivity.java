package com.example.movielist.ui.moviedetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.movielist.R;
import com.example.movielist.models.Movie;
import com.example.movielist.ui.editmovie.EditMovieActivity;
import com.example.movielist.ui.main.MainActivity;
import com.example.movielist.ui.movies.MoviesActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    String movieTitle;
    Movie m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movieTitle = getIntent().getStringExtra("MOVIE_TITLE");

        if(Movie.findWithQuery(Movie.class, "Select * from MOVIE where title = ?", movieTitle).get(0) != null) {
            m = Movie.findWithQuery(Movie.class, "Select * from MOVIE where title = ?", movieTitle).get(0);
        }

        TextView title = findViewById(R.id.tvTitle);
        title.setText(m.getTitle());

        TextView rating = findViewById(R.id.tvRating);
        rating.setText(m.getRating() + "/10");

        TextView genre = findViewById(R.id.tvGenre);
        genre.setText(m.getGenre());

        TextView description = findViewById(R.id.tvDescription);
        description.setText(m.getDescription());

        Button edit = findViewById(R.id.btnEditMovie);
        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MovieDetailsActivity.this, EditMovieActivity.class);
                intent.putExtra("MOVIE_TITLE", m.getTitle());
                startActivity(intent);
            }

        });

        Button delete = findViewById(R.id.btnDeleteMovie);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Movie.executeQuery("DELETE from MOVIE where title = ?", m.getTitle());
                Intent intent = new Intent(MovieDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }
}
