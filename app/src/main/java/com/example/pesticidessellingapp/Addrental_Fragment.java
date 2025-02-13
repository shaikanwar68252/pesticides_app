package com.example.pesticidessellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Addrental_Fragment extends Fragment {

    private RecyclerView recyclerViewCart;
    private Button btnProceedRental;
    private addrental_adapter adapter;
    private List<addrental_model> rentalList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_addrental_, container, false);

        recyclerViewCart = view.findViewById(R.id.recyclerView_cart);
        btnProceedRental = view.findViewById(R.id.btn_proceed_rental);

        // Sample rental data
        rentalList = new ArrayList<>();
        rentalList.add(new addrental_model("Tractor X1", "https://example.com/tractor1.jpg", "1000/day"));
        rentalList.add(new addrental_model("Land Plot A", "https://example.com/land1.jpg", "5000/month"));
        rentalList.add(new addrental_model("Harvester H3", "https://example.com/harvester3.jpg", "1800/day"));
        rentalList.add(new addrental_model("Plow P1", "https://example.com/plow1.jpg", "800/day"));

        // Set LayoutManager (Horizontal)
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCart.setLayoutManager(layoutManager);

        // Set Adapter with item click handling
        adapter = new addrental_adapter(requireContext(), rentalList, (position, rentalItem) -> {
            Intent intent;

            // Determine which details activity to open
            if (rentalItem.getProductName().toLowerCase().contains("tractor")) {
                intent = new Intent(requireContext(), Tractors_Details.class);
            } else if (rentalItem.getProductName().toLowerCase().contains("land")) {
                intent = new Intent(requireContext(), Land_Details.class);
            } else {
                Toast.makeText(requireContext(), "Invalid item type", Toast.LENGTH_SHORT).show();
                return;
            }

            // Pass data to the details activity
            intent.putExtra("item_name", rentalItem.getProductName());
            intent.putExtra("image_url", rentalItem.getProductImage());
            intent.putExtra("price", rentalItem.getProductPrice());

            startActivity(intent);
        });


        recyclerViewCart.setAdapter(adapter);

        // Proceed Rental button
        btnProceedRental.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Proceeding with Rental", Toast.LENGTH_SHORT).show()
        );

        return view; // Return inflated layout
    }
}
