package com.giantplay.filmreview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.RatingBar;
=======
>>>>>>> c4e0ee7206e226371a17ed2b3b75ec8eb92dba05
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String title = intent.getStringExtra("movie_title");
        String year = intent.getStringExtra("movie_year");
        String desc = intent.getStringExtra("movie_desc");
<<<<<<< HEAD
        float rating = intent.getFloatExtra("movie_rating", 0.0f);
        int reviewer = intent.getIntExtra("movie_reviewer", 0);
=======
>>>>>>> c4e0ee7206e226371a17ed2b3b75ec8eb92dba05
        int cover = intent.getIntExtra("movie_image", 0);

        TextView titleMovie = findViewById(R.id.txt_title_movie);
        titleMovie.setText(title);

        TextView yearMovie = findViewById(R.id.txt_year_movie);
        yearMovie.setText(year);

        TextView descMovie = findViewById(R.id.txt_desc_movie);
        descMovie.setText(desc);

<<<<<<< HEAD
        RatingBar rbMovie = findViewById(R.id.rb_movie_rating);
        rbMovie.setRating((float) rating);

        TextView reviewerMovie = findViewById(R.id.txt_reviewer_movie);
        String reviewText = Integer.toString(reviewer)+" reviews for this movie";
        reviewerMovie.setText(reviewText);

=======
>>>>>>> c4e0ee7206e226371a17ed2b3b75ec8eb92dba05
        ImageView imageMovie = findViewById(R.id.image_movie);
        imageMovie.setImageResource(cover);

    }
}
