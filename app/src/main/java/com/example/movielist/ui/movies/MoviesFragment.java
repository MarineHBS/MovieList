package com.example.movielist.ui.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movielist.MovieListApplication;
import com.example.movielist.R;
import com.example.movielist.models.Movie;
import com.example.movielist.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MoviesFragment extends Fragment implements MoviesScreen {
    @Inject
    MoviesPresenter moviesPresenter;

    private EditText etMovie;
    private String movieTitle = "shawshank redemption";
    private List<Movie> moviesList;
    private Movie movie;
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerViewMovies;

    public MoviesFragment(){
        MovieListApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        movieTitle = getActivity().getIntent().getStringExtra(MainActivity.KEY_MOVIES);
        moviesPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        moviesPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerViewMovies = view.findViewById(R.id.movies_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMovies.setLayoutManager(llm);

        moviesList = new ArrayList<>();
        moviesAdapter = new MoviesAdapter(getContext(), moviesList);
        recyclerViewMovies.setAdapter(moviesAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(movieTitle.equals("showPersistedMovies")){
            moviesPresenter.showPersistedMovies();
        }else {
            moviesPresenter.refreshMovies(movieTitle);
        }
    }

    public void showMovies() {

        moviesList.clear();
        if(Movie.listAll(Movie.class) != null) {
            moviesList.addAll(Movie.listAll(Movie.class));
        }
        moviesAdapter.notifyDataSetChanged();

        if (moviesList.isEmpty()) {
            recyclerViewMovies.setVisibility(View.GONE);
        } else {
            recyclerViewMovies.setVisibility(View.VISIBLE);
        }
    }

    public void showMovie(Movie movie) {

        moviesList.clear();
        moviesList.add(movie);
        if(!movie.getTitle().equals("No such movie exists in our database")) {
            movie.save();
        }
        moviesAdapter.notifyDataSetChanged();
        if (moviesList.isEmpty()) {
            recyclerViewMovies.setVisibility(View.GONE);
        } else {
            recyclerViewMovies.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_LONG).show();
    }

}
