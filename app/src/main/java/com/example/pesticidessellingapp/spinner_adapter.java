package com.example.pesticidessellingapp;

// Import statements must be at the top
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class spinner_adapter extends AppCompatActivity {
    private Spinner spinnerPaymentMethod;
    private String selectedPaymentMethod = "Cash on Delivery"; // Default selection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_method_page);

        // Initialize Spinner
        spinnerPaymentMethod = findViewById(R.id.spinner_payment_method);

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
                Toast.makeText(getApplicationContext(), "Selected: " + selectedPaymentMethod, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Default selection
                selectedPaymentMethod = "Cash on Delivery";
            }
        });
    }
}
