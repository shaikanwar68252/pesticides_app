package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Delivery_Method_page extends AppCompatActivity {
    private Spinner spinnerPaymentMethod;
    private Button btnProceed;
    private String selectedPaymentMethod = "Cash on Delivery"; // Default selection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_method_page);

        // Initialize Spinner and Button
        spinnerPaymentMethod = findViewById(R.id.spinner_payment_method);
        btnProceed = findViewById(R.id.btnProceed);

        // Payment options
        String[] paymentMethods = {"Cash on Delivery", "Online Payment"};

        // Create and set Adapter for Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paymentMethods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaymentMethod.setAdapter(adapter);

        // Handle Spinner Selection
        spinnerPaymentMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPaymentMethod = parent.getItemAtPosition(position).toString();

                // Change button text based on selection
                if (selectedPaymentMethod.equals("Cash on Delivery")) {
                    btnProceed.setText("Place Order");
                } else {
                    btnProceed.setText("Proceed to Payment");
                }

                // Show Toast message
                Toast.makeText(Delivery_Method_page.this, "Selected: " + selectedPaymentMethod, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Default selection
                selectedPaymentMethod = "Cash on Delivery";
            }
        });

        // Handle Button Click
        btnProceed.setOnClickListener(view -> {
            if (selectedPaymentMethod.equals("Cash on Delivery")) {
                Toast.makeText(Delivery_Method_page.this, "Order Placed with Cash on Delivery", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(Delivery_Method_page.this, "Redirecting to Online Payment...", Toast.LENGTH_LONG).show();
                // Implement payment gateway logic here (e.g., open payment activity)
            }
        });
    }
}
