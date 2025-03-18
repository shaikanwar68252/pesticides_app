package com.example.pesticidessellingapp.userScreens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.Module.CategoryModule;
import com.example.pesticidessellingapp.Module.Product;
import com.example.pesticidessellingapp.Module.ProductResponse;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.api.ApiClient;
import com.example.pesticidessellingapp.api.ApiService;
import com.example.pesticidessellingapp.databinding.FragmentUserHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserHomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserHomeAdapter adapter;
    private List<Product> productList;

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


        initializeAdapters(view);
        loadCategories();
        loadProducts();


//

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

    private void loadProducts() {

        ApiService service = ApiClient.getClient().create(ApiService.class);
        service.getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getStatus().equals("success")){
                        productList.addAll(response.body().getProducts());
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Log.d("TAG", "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });

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


    private void initializeAdapters(View view) {
        categoryAdapter = new UserCategoryAdapter(categoryList, getContext());
        binding.categoryRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.categoryRV.setAdapter(categoryAdapter);

        recyclerView = view.findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);

        productList = new ArrayList<>();

        adapter = new UserHomeAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);

    }




}
