package com.example.movielist.ui.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movielist.R;
import com.example.movielist.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context context;
    private List<Movie> moviesList;

    public MoviesAdapter(Context context, List<Movie> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = moviesList.get(position);

        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getYear());
        holder.tvDescription.setText(movie.getDescription());
        holder.tvRating.setText(movie.getRating());
        holder.tvGenre.setText(movie.getGenre());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvYear;
        public TextView tvDescription;
        public TextView tvRating;
        public TextView tvGenre;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvGenre = itemView.findViewById(R.id.tvGenre);
        }
    }
}