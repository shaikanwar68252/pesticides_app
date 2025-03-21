package com.example.pesticidessellingapp.userScreens;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

import java.util.Calendar;

public class ProceedRent extends AppCompatActivity {
    private TextView dateTextView, timeTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed_rent);

        dateTextView = findViewById(R.id.textView443); // Date text
        timeTextView = findViewById(R.id.textView444); // Time slot text

        findViewById(R.id.date_card_rent).setOnClickListener(v -> showDatePicker());
        findViewById(R.id.time_card_rent).setOnClickListener(v -> showTimePicker());
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
            dateTextView.setText(selectedDate);
        }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute1) -> {
            String selectedTime = hourOfDay + ":" + String.format("%02d", minute1);
            timeTextView.setText(selectedTime);
        }, hour, minute, true);
        timePickerDialog.show();
    }
}