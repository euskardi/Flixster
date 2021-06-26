package com.example.simpletodo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpletodo.models.Movie;
import com.example.simpletodo.databinding.SingularMovieBinding;


import org.parceler.Parcels;

public class OneMovie extends AppCompatActivity {
    Movie movie;

    TextView tvTitle;
    TextView tvOverview;
    RatingBar rvVoteAverage;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get binding created from enabling ViewBinding
        SingularMovieBinding binding = SingularMovieBinding.inflate(getLayoutInflater());
        //Set view
        View view = binding.getRoot();
        setContentView(view);
        //Binding every element needed.
        tvTitle = binding.tvTitle;
        tvOverview = binding.tvOverview;
        rvVoteAverage = binding.rvVoteAverage;

        /*setContentView(R.layout.singular_movie);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        rvVoteAverage = findViewById(R.id.rvVoteAverage);
        ivPoster = findViewById(R.id.ivPoster);*/

        movie = Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        rvVoteAverage.setRating(movie.getRating().floatValue() / 2.0f);

        String imageUrl;
        //if phone is in landscape
            imageUrl = movie.getBackdropPath();
    }


}
