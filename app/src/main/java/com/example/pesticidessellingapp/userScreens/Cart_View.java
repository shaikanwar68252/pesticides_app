package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.ArrayList;
import java.util.List;

public class Cart_View extends AppCompatActivity {
    private RecyclerView recyclerView;
    private cartview_Adapter cartAdapter;
    private List<CartViewModel> cartItemList;
    private TextView subtotal, shipping, tax, total;
    private Button proceedToCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        recyclerView = findViewById(R.id.recycler_view_orders);
        subtotal = findViewById(R.id.textView453);
        shipping = findViewById(R.id.textView454);
        tax = findViewById(R.id.textView45);
        total = findViewById(R.id.textView4541);
        proceedToCheckout = findViewById(R.id.btn_proceed_rental1);

        cartItemList = new ArrayList<>();
        loadCartItems();

        cartAdapter = new cartview_Adapter(this, cartItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        updateSummary();
    }

    private void loadCartItems() {
        cartItemList.add(new CartViewModel("Agricultural Growth Enhancer", "Category III", R.drawable.image_1, 49.99, 2));
        cartItemList.add(new CartViewModel("Organic Pesticide", "Category I", R.drawable.image_1, 39.99, 1));
        cartItemList.add(new CartViewModel("Tractor Engine Oil", "Category II", R.drawable.image_1, 19.99, 3));
    }

    private void updateSummary() {
        double subtotalValue = 0;
        for (CartViewModel item : cartItemList) {
            subtotalValue += item.getPrice() * item.getQuantity();
        }

        double shippingValue = 5.99;
        double taxValue = subtotalValue * 0.1;
        double totalValue = subtotalValue + shippingValue + taxValue;

        subtotal.setText("$" + String.format("%.2f", subtotalValue));
        shipping.setText("$" + String.format("%.2f", shippingValue));
        tax.setText("$" + String.format("%.2f", taxValue));
        total.setText("$" + String.format("%.2f", totalValue));

        proceedToCheckout.setText("Proceed to Checkout • $" + String.format("%.2f", totalValue));
    }
}
