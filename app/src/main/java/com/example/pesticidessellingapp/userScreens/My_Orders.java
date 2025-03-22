package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;
import java.util.ArrayList;
import java.util.List;

public class My_Orders extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter_Orders orderAdapter;
    private List<OrderModel> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        recyclerView = findViewById(R.id.recyclerView_orders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample Data
        orderList = new ArrayList<>();
        orderList.add(new OrderModel("ORD-2024-001", "Jan 15, 2024", "Pending",
                "Premium Insecticide Spray", 2, 129.99, R.drawable.home_placeholder));

        orderList.add(new OrderModel("ORD-2024-002", "Feb 10, 2024", "Delivered",
                "Herbal Pesticide", 1, 89.99, R.drawable.home_placeholder));
        orderList.add(new OrderModel("ORD-2024-003", "Mar 5, 2024", "Shipped",
                "Organic Fungicide", 3, 149.99, R.drawable.home_placeholder));

        orderAdapter = new Adapter_Orders(this, orderList);
        recyclerView.setAdapter(orderAdapter);

        // Back Arrow Click Listener
        ImageButton backArrow = findViewById(R.id.backArrow_myorders);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPreviousFragment();
            }
        });
    }

    private void navigateToPreviousFragment() {
        Fragment targetFragment = new UserProfileFragment(); // Replace with your actual target fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.profilefragment_main, targetFragment); // Ensure fragment_container exists in your activity layout
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
