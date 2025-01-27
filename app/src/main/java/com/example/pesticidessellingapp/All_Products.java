package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class All_Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        // Get the FragmentManager for handling fragment transactions
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Set up button to load PesticidesFragment
        Button button19 = findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, new PesticidesFragment(), null)
                        .setReorderingAllowed(true)
                        .addToBackStack("pesticides")
                        .commit();
            }
        });

        // Set up button to load Rental_TractorsFragment
        Button button20 = findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, new Rental_TractorsFragment(), null)
                        .setReorderingAllowed(true)
                        .addToBackStack("rental_tractors")
                        .commit();
            }
        });

        // Set up button to load Tenant_LandsFragment
        Button button21 = findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, new Tenant_LandsFragment(), null)
                        .setReorderingAllowed(true)
                        .addToBackStack("tenant_lands")
                        .commit();
            }
        });
    }
}
