package com.happytrees.simplemvp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Movie> movieList;
    private Activity activity;

    public MyAdapter(List<Movie> movieList, Activity activity) {
        this.movieList = movieList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.textView.setText(movie.title);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
