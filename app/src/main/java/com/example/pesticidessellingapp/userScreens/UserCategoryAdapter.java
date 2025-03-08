package com.example.pesticidessellingapp.userScreens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pesticidessellingapp.Module.CategoryModule;
import com.example.pesticidessellingapp.R;

import java.util.ArrayList;

public class UserCategoryAdapter extends RecyclerView.Adapter<UserCategoryAdapter.ViewHolder> {

    private ArrayList<CategoryModule> list;
    private Context context;

    public UserCategoryAdapter(ArrayList<CategoryModule> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public UserCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCategoryAdapter.ViewHolder holder, int position) {

        CategoryModule item = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(item.getImageUrl())
                .placeholder(R.drawable.home_placeholder)
                .error(R.drawable.home_placeholder)
                .into(holder.categoryIc);

        holder.categoryName.setText(item.getCategoryName());

        holder.itemView.setOnClickListener(view -> {
            // Create an instance of the fragment
            UserHomeSearchFragment searchFragment = new UserHomeSearchFragment();

            // ✅ Pass category name using Bundle
            Bundle bundle = new Bundle();
            bundle.putString("CATEGORY_NAME", item.getCategoryName());
            searchFragment.setArguments(bundle);

            // ✅ Replace current fragment with UserHomeSearchFragment
            ((AppCompatActivity) context).getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, searchFragment)
                    .addToBackStack(null)
                    .commit();
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryIc;
        TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryIc = itemView.findViewById(R.id.item_image);
            categoryName = itemView.findViewById(R.id.item_text);

        }
    }
}
