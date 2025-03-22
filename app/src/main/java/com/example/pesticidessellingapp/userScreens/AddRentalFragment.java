package com.example.pesticidessellingapp.userScreens;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.example.pesticidessellingapp.R;

public class AddRentalFragment extends AppCompatActivity {

    private RadioGroup categoryGroup;
    private EditText etPropertyTitle, etLocation, etArea, etRate, etDescription;
    private CheckBox cbTerms;
    private Button btnListProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_rental);

        categoryGroup = findViewById(R.id.categoryGroup);
        etPropertyTitle = findViewById(R.id.etPropertyTitle);
        etLocation = findViewById(R.id.etLocation);
        etArea = findViewById(R.id.etArea);
        etRate = findViewById(R.id.etRate);
        etDescription = findViewById(R.id.etDescription);
        cbTerms = findViewById(R.id.cbTerms);
        btnListProperty = findViewById(R.id.btnListProperty);

        btnListProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postProperty();
            }
        });
    }

    private void postProperty() {
        int selectedCategoryId = categoryGroup.getCheckedRadioButtonId();
        if (selectedCategoryId == -1) {
            Toast.makeText(this, "Please select a category", Toast.LENGTH_SHORT).show();
            return;
        }
        String category = ((RadioButton) findViewById(selectedCategoryId)).getText().toString();
        String title = etPropertyTitle.getText().toString().trim();
        String location = etLocation.getText().toString().trim();
        String area = etArea.getText().toString().trim();
        String rate = etRate.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        if (title.isEmpty() || location.isEmpty() || area.isEmpty() || rate.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here, you can send the data to the backend or database
        Toast.makeText(this, "Property listed successfully", Toast.LENGTH_SHORT).show();
    }
}
