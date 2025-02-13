package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import androidx.core.util.Pair;  // Use correct Pair import

public class Land_Details extends AppCompatActivity {

    private ImageView imgLand;
    private TextView txtLandName, txtPrice;
    private Button btnSelectYear, btnConfirmBooking;
    private String selectedDateRange = "Select Year Range";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_details);

        imgLand = findViewById(R.id.img_land);
        txtLandName = findViewById(R.id.txt_land_name);
        txtPrice = findViewById(R.id.txt_price);
        btnSelectYear = findViewById(R.id.btn_select_year);
        btnConfirmBooking = findViewById(R.id.btn_confirm_booking);

        // Get data from intent
        String landName = getIntent().getStringExtra("land_name");
        String imageUrl = getIntent().getStringExtra("image_url");
        String price = getIntent().getStringExtra("price");

        txtLandName.setText(landName);
        txtPrice.setText("Price: " + price);
        Glide.with(this).load(imageUrl).into(imgLand);

        btnSelectYear.setOnClickListener(v -> openDatePicker());

        btnConfirmBooking.setOnClickListener(v ->
                Toast.makeText(Land_Details.this, "Booked: " + landName + " from " + selectedDateRange, Toast.LENGTH_SHORT).show()
        );
    }

    private void openDatePicker() {
        // Ensure only future dates can be selected
        CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
        constraintsBuilder.setValidator(DateValidatorPointForward.now());

        // Use the correct Pair import for date range picker
        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select Year Range");
        builder.setCalendarConstraints(constraintsBuilder.build());

        MaterialDatePicker<Pair<Long, Long>> picker = builder.build();

        picker.show(getSupportFragmentManager(), "DATE_PICKER");

        picker.addOnPositiveButtonClickListener(selection -> {
            selectedDateRange = picker.getHeaderText();
            btnSelectYear.setText(selectedDateRange);
        });
    }
}
