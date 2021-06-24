package com.example.simpletodo;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpletodo.models.Movie;

import org.parceler.Parcels;

public class OneMovie extends AppCompatActivity {
    Movie movie;

    TextView tvTitle;
    TextView tvOverview;
    RatingBar rvVoteAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singular_movie);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        rvVoteAverage = findViewById(R.id.rvVoteAverage);

        movie = Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        rvVoteAverage.setRating(movie.getRating().floatValue() / 2.0f);
    }
}
