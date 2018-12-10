package com.happytrees.simplemvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        MovieRepository movieRepository = new MovieRepository();
        MoviePresenter moviePresenter = new MoviePresenter(movieRepository,this);
        moviePresenter.requestDataFromServer();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void displayMovies(ArrayList<Movie> movieArrayList) {
        MyAdapter myAdapter = new MyAdapter(movieArrayList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}
