package com.example.pesticidessellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Order_sucessfull_page extends AppCompatActivity {
    private TextView txtSuccessMessage, txtOrderDetails, txtUserName, txtUserAddress;
    private ImageView imgProduct;
    private Button btnContinueShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_sucessfull);

        // Initialize Views
        txtSuccessMessage = findViewById(R.id.sucessfullmessage);
        txtOrderDetails = findViewById(R.id.text112);
        txtUserName = findViewById(R.id.user_address);
        txtUserAddress = findViewById(R.id.user_address);
        imgProduct = findViewById(R.id.imageorder);
        btnContinueShopping = findViewById(R.id.btn_continue_shopping);

        // Get Data from Intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("PRODUCT_NAME");
        String productPrice = intent.getStringExtra("PRODUCT_PRICE");
        String productQuantity = intent.getStringExtra("PRODUCT_QUANTITY");
        String userName = intent.getStringExtra("USER_NAME");
        String userAddress = intent.getStringExtra("USER_ADDRESS");

        // Set Data to Views
        txtSuccessMessage.setText("🎉 Order Placed Successfully!");
        txtOrderDetails.setText("Product: " + productName + "\nPrice: " + productPrice + "\nQuantity: " + productQuantity);
        txtUserName.setText(userName);
        txtUserAddress.setText(userAddress);
        imgProduct.setImageResource(R.drawable.app_picture); // Set product image

        // Continue Shopping Button Click Listener
        btnContinueShopping.setOnClickListener(view -> {
            Intent homeIntent = new Intent(Order_sucessfull_page.this, MainActivity.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            finish();
        });
    }
}
