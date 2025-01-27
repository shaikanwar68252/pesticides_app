package com.example.pesticidessellingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<String> titles;
    private List<Integer> images;

    // Constructor
    public MyAdapter(Context context, List<String> titles, List<Integer> images) {
        this.context = context;
        this.titles = titles;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind data to the view holder
        holder.textView.setText(titles.get(position));
        holder.imageView.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        // Return the size of the list
        return titles.size();
    }

    // ViewHolder class
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
