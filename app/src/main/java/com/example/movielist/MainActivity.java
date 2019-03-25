package com.example.movielist;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.movielist.Models.Movie;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MovieAdapter(myDataset);
        recyclerView.setAdapter(myAdapter);

        FloatingActionButton add = findViewById(R.id.addNewMovie);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view, "movie added", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, AddNewMovieActivity.class);
                startActivity(intent);
            }

        });



    }
}
    public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter>{
        public static class MovieViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            public MovieViewHolder(TextView v){
                super(v);
                textView = v;
            }
        }
        @Override
        public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
            MovieViewHolder vh = new MovieViewHolder(v);
            return vh;
        }
        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.textView.setText(myDataset[position]);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return myDataset.length;
        }
    }
