package com.example.pesticidessellingapp.userScreens;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

public class Payment_Gateway_Rental extends AppCompatActivity {

    private TextView txtTractorName, txtPrice, txtSelectedDate;
    private Button btnProceedToPay;
    private String tractorName, price, selectedDate, selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_gateway_rental);

        txtTractorName = findViewById(R.id.txt_land_name);
        txtPrice = findViewById(R.id.txt_price);
        txtSelectedDate = findViewById(R.id.txt_booking_details);
        btnProceedToPay = findViewById(R.id.btn_pay);

        // Get data from Intent
        Intent intent = getIntent();
        tractorName = intent.getStringExtra("tractor_name");
        price = intent.getStringExtra("price");
        selectedDate = intent.getStringExtra("selected_date");
        selectedTime = intent.getStringExtra("selected_time");

        // Set data
        txtTractorName.setText("Tractor: " + tractorName);
        txtPrice.setText("Price: $" + price);
        txtSelectedDate.setText("Date: " + selectedDate);


        // Proceed to PayPal Payment Gateway
        btnProceedToPay.setOnClickListener(v -> redirectToPayPal());
    }

    private void redirectToPayPal() {
        String businessEmail = "your-paypal-business-email@example.com"; // Replace with your PayPal business email
        String currencyCode = "USD";  // Change to the appropriate currency
        String paypalUrl = "https://www.paypal.com/cgi-bin/webscr?cmd=_xclick&business=" + businessEmail +
                "&amount=" + price +
                "&currency_code=" + currencyCode +
                "&item_name=" + tractorName +
                "&return=https://yourwebsite.com/payment-success" +  // Replace with your success URL
                "&cancel_return=https://yourwebsite.com/payment-failure"; // Replace with your failure URL

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(paypalUrl));
        startActivity(browserIntent);
    }
}
