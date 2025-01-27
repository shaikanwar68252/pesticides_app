package com.example.pesticidessellingapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.MyAdapter;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<String> titles;
    private List<Integer> images;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout using View Binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        // Initialize RecyclerView
        RecyclerView recyclerView = binding.recyclerView;

        // Initialize data lists
        titles = new ArrayList<>();
        images = new ArrayList<>();

        // Populate data
        images.add(R.drawable.whatsapp_image_2024_12_30_at_11_09_48_am);
        images.add(R.drawable.image_6);
        images.add(R.drawable.image_3);
        images.add(R.drawable.image_9);
        images.add(R.drawable.image_5);
        images.add(R.drawable.image_4);
        images.add(R.drawable.image_1);
        images.add(R.drawable.image_2);

        titles.add("square finish");
        titles.add("square finish");
        titles.add("square finish");
        titles.add("square finish");
        titles.add("square finish");
        titles.add("square finish");
        titles.add("square finish");
        titles.add("square finish");

        // Set up adapter
        adapter = new MyAdapter(getContext(), titles, images);

        // Set up RecyclerView with GridLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Avoid memory leaks
    }
}
