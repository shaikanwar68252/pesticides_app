package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

public class Payment_Gateway extends AppCompatActivity {

    private TextView tvQuantity, tvTotalPrice, tvNetPrice;
    private int quantity = 1;
    private final double pricePerItem = 983.0;
    private final double discountPerItem = 9.83;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_gateway);

        tvQuantity = findViewById(R.id.tv_quantity);
        tvTotalPrice = findViewById(R.id.payment);
        tvNetPrice = findViewById(R.id.payment_gateway2);
        ImageView btnDecrease = findViewById(R.id.btn_decrease);
        ImageView btnIncrease = findViewById(R.id.btn_increase);
        Button btnProceed = findViewById(R.id.btn_proceed);
        CheckBox checkboxTerms = findViewById(R.id.checkbox_terms);

        updatePrice(); // Initialize price display

        btnIncrease.setOnClickListener(v -> updateQuantity(1));
        btnDecrease.setOnClickListener(v -> updateQuantity(-1));

        btnProceed.setOnClickListener(v -> {
            if (checkboxTerms.isChecked()) {
                Toast.makeText(this, "Proceeding to Checkout...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please accept the terms", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateQuantity(int change) {
        quantity += change;
        if (quantity < 1) quantity = 1;
        tvQuantity.setText(String.valueOf(quantity));
        updatePrice();
    }

    private void updatePrice() {
        double totalPrice = pricePerItem * quantity;
        double totalDiscount = discountPerItem * quantity;
        double netPrice = totalPrice - totalDiscount;

        tvTotalPrice.setText("Total Price: ₹" + String.format("%.2f", totalPrice));
        tvNetPrice.setText("Net Price: ₹" + String.format("%.2f", netPrice));
    }
}
