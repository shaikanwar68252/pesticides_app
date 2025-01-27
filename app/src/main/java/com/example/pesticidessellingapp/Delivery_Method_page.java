package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class Delivery_Method_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_method_page);

        // Initialize the spinner
        Spinner deliveryMethodSpinner = findViewById(R.id.spinner);

        // Define the delivery methods
        List<String> deliveryMethods = Arrays.asList("Cash on Delivery", "Online Payment");

        // Set up the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                deliveryMethods
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attach the adapter to the spinner
        deliveryMethodSpinner.setAdapter(adapter);

        // Set up the spinner's item selection listener
        deliveryMethodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMethod = parent.getItemAtPosition(position).toString();
                Toast.makeText(Delivery_Method_page.this, "Selected: " + selectedMethod, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Optional: Add behavior for when no item is selected
            }
        });
    }
}
