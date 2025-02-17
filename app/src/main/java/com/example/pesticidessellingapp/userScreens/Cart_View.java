package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.ArrayList;
import java.util.List;

public class Cart_View extends AppCompatActivity {
    private RecyclerView recyclerView;
    private cartview_Adapter adapter;
    private List<cartview_model> cartItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        recyclerView = findViewById(R.id.cart_recycle1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cartItemList = new ArrayList<>();
        loadCartItems();

        adapter = new cartview_Adapter(this, cartItemList);
        recyclerView.setAdapter(adapter);
    }

    private void loadCartItems() {
        cartItemList.add(new cartview_model("Pesticide A", 12.99, 2, "file:///C:/Users/AD-LAB/Downloads/pes"));
        cartItemList.add(new cartview_model("Pesticide B", 8.49, 1, "https://example.com/image2.jpg"));
        cartItemList.add(new cartview_model("Pesticide C", 15.99, 3, "https://example.com/image3.jpg"));
    }
}
