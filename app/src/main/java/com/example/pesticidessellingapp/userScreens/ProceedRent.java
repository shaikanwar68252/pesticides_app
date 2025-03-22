package com.example.pesticidessellingapp.userScreens;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.example.pesticidessellingapp.R;

import java.util.Calendar;
import java.util.Locale;

public class ProceedRent extends AppCompatActivity {

    private TextView tvDateRange, tvBaseRate, tvServiceFee, tvTax, tvTotalPrice, tvProductName, tvProductPrice, tvProductDescription;
    private ImageView ivProductImage;
    private ImageButton backButton;

    private double hourlyRate = 75.00;
    private double serviceFee = 10.00;
    private double tax = 5.00;
    private int selectedHours = 5;  // Default rental duration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed_rent);

        // Initialize UI elements
        tvDateRange = findViewById(R.id.date_card_rent);
        tvBaseRate = findViewById(R.id.baserate_rent);
        tvServiceFee = findViewById(R.id.service_rent);
        tvTax = findViewById(R.id.tax_rent);
        tvTotalPrice = findViewById(R.id.taxamount_rent);
        tvProductName = findViewById(R.id.proname_rent);
        tvProductPrice = findViewById(R.id.productprice_rent);
        tvProductDescription = findViewById(R.id.product_desc_rent);
        ivProductImage = findViewById(R.id.product_rental1);
        backButton = findViewById(R.id.backArrow_rentals);  // ImageButton

        AppCompatButton btnProceedPayment = findViewById(R.id.btn_proceed_rental_payment);

        // Set product details dynamically
        tvProductName.setText("John Deere 5E Series Tractor");
        tvProductDescription.setText("75 HP tractor with advanced features and excellent fuel efficiency");
        tvProductPrice.setText("$75.00/hour");
        ivProductImage.setImageResource(R.drawable.home_placeholder);

        // Date Picker
        tvDateRange.setOnClickListener(view -> showDatePicker());

        // Calculate total price initially
        calculateTotalPrice();

        // ImageButton Click Listener (Navigate to another activity)
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(ProceedRent.this, ActivityDocumentVerify.class); // Change 'MainActivity' to your target activity
            startActivity(intent);
            finish();  // Optional: Finish current activity to prevent going back
        });

        // Proceed to Payment Button Click
        btnProceedPayment.setOnClickListener(view -> {
            // TODO: Implement payment logic here
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> {
                    String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%d", dayOfMonth, month1 + 1, year1);
                    tvDateRange.setText(selectedDate);
                    calculateTotalPrice(); // Recalculate total price after selecting a date
                }, year, month, day);
        datePickerDialog.show();
    }

    private void calculateTotalPrice() {
        double baseRate = hourlyRate * selectedHours;
        double totalPrice = baseRate + serviceFee + tax;

        tvBaseRate.setText(String.format(Locale.getDefault(), "$%.2f", baseRate));
        tvServiceFee.setText(String.format(Locale.getDefault(), "$%.2f", serviceFee));
        tvTax.setText(String.format(Locale.getDefault(), "$%.2f", tax));
        tvTotalPrice.setText(String.format(Locale.getDefault(), "$%.2f", totalPrice));
    }
}
