package com.example.pesticidessellingapp.adminScreens;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.pesticidessellingapp.Auth.LoginActivity;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.ActivityLoginBinding;

public class AdminDashboard extends AppCompatActivity {

    private CardView addNewProduct, updateStock, viewInventory, generateReport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Initialize UI components
        addNewProduct = findViewById(R.id.add_newproduct);
        updateStock = findViewById(R.id.updatestock_admin);
        viewInventory = findViewById(R.id.inventory_admin);
        generateReport = findViewById(R.id.generate_admin);
        LinearLayout linearLayout = findViewById(R.id.logout);

        // Set click listeners
        addNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, AdminAddProductActivity.class));
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, LoginActivity.class));
            }
        });


    }
}
