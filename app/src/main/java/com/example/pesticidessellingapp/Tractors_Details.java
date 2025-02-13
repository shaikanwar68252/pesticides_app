package com.example.pesticidessellingapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Calendar;

public class Tractors_Details extends AppCompatActivity {

    private ImageView imgTractor;
    private TextView txtTractorName, txtPrice, txtDescription;
    private Button btnSelectDate, btnSelectTime, btnBookNow;
    private String selectedDate = "", selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tractors_details);

        // Initialize UI components
        imgTractor = findViewById(R.id.img_tractor1);
        txtTractorName = findViewById(R.id.txt_tractor_name1);
        txtPrice = findViewById(R.id.txt_price1);
        txtDescription = findViewById(R.id.txt_description1);
        btnSelectDate = findViewById(R.id.btn_select_date1);
        btnSelectTime = findViewById(R.id.btn_select_time1);
        btnBookNow = findViewById(R.id.btn_book_now1);

        // Get data from Intent
        Intent intent = getIntent();
        String tractorName = intent.getStringExtra("tractor_name");
        String imageUrl = intent.getStringExtra("image_url");
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");

        // Set data in views
        txtTractorName.setText(tractorName);
        txtPrice.setText("Price: " + price);
        txtDescription.setText(description);
        Glide.with(this).load(imageUrl).into(imgTractor);

        // Date Picker
        btnSelectDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
                selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                btnSelectDate.setText(selectedDate);
            }, year, month, day);
            datePickerDialog.show();
        });

        // Time Picker
        btnSelectTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute1) -> {
                selectedTime = hourOfDay + ":" + (minute1 < 10 ? "0" + minute1 : minute1);
                btnSelectTime.setText(selectedTime);
            }, hour, minute, true);
            timePickerDialog.show();
        });

        // Confirm Booking - Navigate to Payment Page
        btnBookNow.setOnClickListener(v -> {
            if (selectedDate.isEmpty() || selectedTime.isEmpty()) {
                Toast.makeText(this, "Please select date and time", Toast.LENGTH_SHORT).show();
            } else {
                // Navigate to PaymentActivity
                Intent paymentIntent = new Intent(this, Payment_Gateway_Rental.class);
                paymentIntent.putExtra("tractor_name", tractorName);
                paymentIntent.putExtra("image_url", imageUrl);
                paymentIntent.putExtra("price", price);
                paymentIntent.putExtra("description", description);
                paymentIntent.putExtra("selected_date", selectedDate);
                paymentIntent.putExtra("selected_time", selectedTime);
                startActivity(paymentIntent);
            }
        });
    }
}
