package com.example.pesticidessellingapp.userScreens;

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
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.Module.CategoryModule;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.FragmentUserHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class UserHomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserHomeAdapter adapter;
    private List<Model_Home> productList;

    private ArrayList<CategoryModule> categoryList;
    private UserCategoryAdapter categoryAdapter;


    FragmentUserHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentUserHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        categoryList = new ArrayList<>();

        binding.toolbar.setOnMenuItemClickListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.cart) {
                Intent intent = new Intent(getActivity(), Cart_View.class);
                startActivity(intent);
            }
            return true;
        });


        initializeAdapters();
        loadCategories();

        recyclerView = view.findViewById(R.id.recyclerView);

        // ✅ Set Layout Manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // ✅ Fix scrolling inside NestedScrollView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);

        // Sample product list
        productList = new ArrayList<>();
        productList.add(new Model_Home("Bamboo Water Bottle", "https://m.media-amazon.com/images/I/818lES8tpmL.jpg", 24.99));
        productList.add(new Model_Home("Recycled Paper Notebook", "https://example.com/notebook.jpg", 12.49));
        productList.add(new Model_Home("Reusable Coffee Cup", "https://example.com/cup.jpg", 18.99));
        productList.add(new Model_Home("Organic Cotton Tote", "https://example.com/tote.jpg", 15.99));
        productList.add(new Model_Home("Bamboo Cutlery Set", "https://example.com/cutlery.jpg", 7.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));

        adapter = new UserHomeAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);

        binding.searchBar.setOnClickListener(view1 -> {
            // Replace with the new fragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, new UserHomeSearchFragment()) // Change to your actual fragment
                    .addToBackStack(null) // Allows back navigation
                    .commit();
        });

        binding.shopNowBtn.setOnClickListener( v ->{
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, new UserHomeSearchFragment()) // Change to your actual fragment
                    .addToBackStack(null) // Allows back navigation
                    .commit();
        });




        return view;
    }

    private void loadCategories() {
        // ✅ Add multiple categories
        categoryList.add(new CategoryModule("https://example.com/insecticides.jpg", "Insecticides"));
        categoryList.add(new CategoryModule("https://example.com/herbicides.jpg", "Herbicides"));
        categoryList.add(new CategoryModule("https://example.com/fungicides.jpg", "Fungicides"));
        categoryList.add(new CategoryModule("https://example.com/fertilizers.jpg", "Fertilizers"));
        categoryList.add(new CategoryModule("https://example.com/fertilizers.jpg", "Fertilizers"));
        categoryList.add(new CategoryModule("https://example.com/fertilizers.jpg", "Fertilizers"));

        // ✅ Notify adapter after data is added
        categoryAdapter.notifyDataSetChanged();
    }


    private void initializeAdapters() {
        categoryAdapter = new UserCategoryAdapter(categoryList, getContext());
        binding.categoryRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.categoryRV.setAdapter(categoryAdapter);
    }




}
