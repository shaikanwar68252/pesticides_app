package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Booking_Sucessful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure your layout file name is correct

        // Find the TextView for booking info
        TextView bookingInfo = findViewById(R.id.info_book11);

        // Fetch booking details (This can be received via Intent or Database)
        String item = getIntent().getStringExtra("item_name"); // Example: "Tractor"
        String duration = getIntent().getStringExtra("duration"); // Example: "1 Year"
        String price = getIntent().getStringExtra("price"); // Example: "₹5000"

        // Handle null values (if Intent extras are missing)
        if (item == null) item = "Tractor";
        if (duration == null) duration = "1 Year";
        if (price == null) price = "₹5000";

        // Update the TextView dynamically
        bookingInfo.setText("Item: " + item + "\nDuration: " + duration + "\nPrice: " + price);
    }
}
