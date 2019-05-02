package com.example.movielist.ui.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movielist.MovieListApplication;
import com.example.movielist.R;
import com.example.movielist.model.Movie;
import com.example.movielist.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MoviesFragment extends Fragment implements MoviesScreen {
    @Inject
    MoviesPresenter moviesPresenter;

    private EditText etMovie;
    private String movie = "shawshank redemption";
    private List<Movie> moviesList;
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerViewMovies;

    public MoviesFragment(){
        MovieListApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        movie = getActivity().getIntent().getStringExtra(MainActivity.KEY_MOVIES);
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
        etMovie = view.findViewById(R.id.etMovie);
        etMovie.setText(movie);
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
<<<<<<< HEAD
        moviesPresenter.refreshMovies(movie);
=======
        moviesPresenter.refreshMovies();
>>>>>>> 088865a96af54a5c0ef479c038d7382aa07cb367
    }

    public void showMovies(List<Movie> movies) {

        moviesList.clear();
        moviesList.addAll(movies);
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
