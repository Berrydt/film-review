package com.giantplay.filmreview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        final MoviesAdapter moviesAdapter = new MoviesAdapter(this, movies);
        gridView.setAdapter(moviesAdapter);

        Intent intent = new Intent(this, DetailActivity.class);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Movie movie = movies[position];
                movie.toggleFavorite();

                Intent intent = new Intent(parent.getContext(), DetailActivity.class);
                intent.putExtra("movie_title", parent.getContext().getString(movie.getName()));
                intent.putExtra("movie_year", parent.getContext().getString(movie.getYear()));
                intent.putExtra("movie_desc", parent.getContext().getString(movie.getDesc()));
                intent.putExtra("movie_image", movie.getImageResource());
                startActivity(intent);

                // This tells the GridView to redraw itself
                // in turn calling your BooksAdapter's getView method again for each cell
                moviesAdapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Movie[] movies = {
        new Movie(R.string.aquaman, R.string.y_2018, R.drawable.aquaman, R.string.d_aquaman),
        new Movie(R.string.bumblebee, R.string.y_2018, R.drawable.bumblebee, R.string.d_bumblebee),
        new Movie(R.string.hereditary, R.string.y_2018, R.drawable.hereditary, R.string.d_hereditary),
        new Movie(R.string.black_panther, R.string.y_2018, R.drawable.blackpanther, R.string.d_black_panther),
        new Movie(R.string.frozen, R.string.y_2013, R.drawable.frozen, R.string.d_frozen),
        new Movie(R.string.coco, R.string.y_2017, R.drawable.coco, R.string.d_coco),
        new Movie(R.string.pengabdi_setan, R.string.y_2018, R.drawable.pengabdisetan, R.string.d_pengabdi),
        new Movie(R.string.marry_poppins, R.string.y_2018, R.drawable.marypoppins, R.string.d_marry),
        new Movie(R.string.a_quiet_place, R.string.y_2018, R.drawable.quietplace, R.string.d_quiet),
        new Movie(R.string.dilan, R.string.y_2018, R.drawable.dilan1990, R.string.d_dilan)
    };
}
