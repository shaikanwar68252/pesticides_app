package com.example.pesticidessellingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSample extends AppCompatActivity {

    RecyclerViewAdapter adapter;
    List<ProductItem> list;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view_sample);

        recyclerView =  findViewById(R.id.recyclerView);

        list = new ArrayList<>();
        adapter = new RecyclerViewAdapter(list);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.setAdapter(adapter);

        loadProducts();

    }

    private void loadProducts() {


        list.add(new ProductItem(R.drawable.app_picture,"Product Name"," $ 2002"));
        list.add(new ProductItem(R.drawable.app_picture,"Product Name"," $ 2002"));
        list.add(new ProductItem(R.drawable.app_picture,"Product Name"," $ 2002"));
        list.add(new ProductItem(R.drawable.app_picture,"Product Name"," $ 2002"));
        list.add(new ProductItem(R.drawable.app_picture,"Product Name"," $ 2002"));


    }
}