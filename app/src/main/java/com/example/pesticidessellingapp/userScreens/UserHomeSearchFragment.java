package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pesticidessellingapp.Module.Product;
import com.example.pesticidessellingapp.Module.ProductResponse;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.FragmentUserHomeSearchBinding;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserHomeSearchFragment extends Fragment {

    FragmentUserHomeSearchBinding binding;
    private RecyclerView recyclerView;
    private UserHomeAdapter adapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserHomeSearchBinding.inflate(inflater, container, false);



        recyclerView = binding.getRoot().findViewById(R.id.recyclerView);

        // ✅ Set Layout Manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // ✅ Fix scrolling inside NestedScrollView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);

        // Sample product list
        productList = new ArrayList<>();
//        productList.add(new Model_Home("Bamboo Water Bottle", "https://m.media-amazon.com/images/I/818lES8tpmL.jpg", 24.99));
//        productList.add(new Model_Home("Recycled Paper Notebook", "https://example.com/notebook.jpg", 12.49));
//        productList.add(new Model_Home("Reusable Coffee Cup", "https://example.com/cup.jpg", 18.99));
//        productList.add(new Model_Home("Organic Cotton Tote", "https://example.com/tote.jpg", 15.99));
//        productList.add(new Model_Home("Bamboo Cutlery Set", "https://example.com/cutlery.jpg", 7.99));
//        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
//        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
//        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
//        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));
//        productList.add(new Model_Home("Glass Food Container", "https://example.com/container.jpg", 22.99));

        adapter = new UserHomeAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ✅ Receive category name from arguments
        if (getArguments() != null && getArguments().containsKey("CATEGORY_NAME")) {
            String categoryName = getArguments().getString("CATEGORY_NAME");

            // ✅ Set search text and trigger filtering
            binding.searchBar.setQuery(categoryName, true);
            filter(categoryName);
        }


        // Ensure SearchView is expanded and focused
        binding.searchBar.setIconified(false);  // Expands the search view
        binding.searchBar.requestFocus();       // Requests focus

        // Delay to ensure keyboard opens
        view.postDelayed(() -> {
            InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.showSoftInput(binding.searchBar.findFocus(), InputMethodManager.SHOW_IMPLICIT);
            }
        }, 0); // Delay to ensure UI is fully loaded


        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String query) {
        List<Product> filteredList = new ArrayList<>();
        for (Product item : productList) {
            if (item.getProductName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter = new UserHomeAdapter(getContext(), filteredList);
        recyclerView.setAdapter(adapter);
    }
}
