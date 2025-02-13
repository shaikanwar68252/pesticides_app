package com.example.pesticidessellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private Home_Adapter adapter;
    private List<Model_Home> productList;
    private EditText searchBar;
    private ImageView cartIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        searchBar = view.findViewById(R.id.search_bar);
        cartIcon = view.findViewById(R.id.cart_icon11); // Find cart icon

        // ✅ Set Layout Manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // ✅ Fix scrolling inside NestedScrollView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);

        // Sample product list
        productList = new ArrayList<>();
        productList.add(new Model_Home("Bamboo Water Bottle", "https://example.com/bottle.jpg", 24.99));
        productList.add(new Model_Home("Recycled Paper Notebook", "https://example.com/notebook.jpg", 12.49));
        productList.add(new Model_Home("Reusable Coffee Cup", "https://example.com/cup.jpg", 18.99));
        productList.add(new Model_Home("Organic Cotton Tote", "https://example.com/tote.jpg", 15.99));
        productList.add(new Model_Home("Bamboo Cutlery Set", "https://example.com/cutlery.jpg", 7.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));

        adapter = new Home_Adapter(getContext(), productList);
        recyclerView.setAdapter(adapter);

        // ✅ Search functionality
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // ✅ Cart Icon Click Listener
        cartIcon.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Cart_View.class);
            startActivity(intent);
        });
    }

    private void filter(String query) {
        List<Model_Home> filteredList = new ArrayList<>();
        for (Model_Home item : productList) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter = new Home_Adapter(getContext(), filteredList);
        recyclerView.setAdapter(adapter);
    }
}
