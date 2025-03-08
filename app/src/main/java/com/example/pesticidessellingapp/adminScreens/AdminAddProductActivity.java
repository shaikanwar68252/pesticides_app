package com.example.pesticidessellingapp.adminScreens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

import java.io.IOException;

public class AdminAddProductActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private EditText productName, brandName, productType, quantity, units, price, discount, keyFeatures, precautions, technicalDetails;
    private ImageView uploadIcon;
    private Button addProductBtn;
    private Uri imageUri;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_product);

        spinner = findViewById(R.id.units);

        String[] items = getResources().getStringArray(R.array.spinner_1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Initialize views
        productName = findViewById(R.id.hint_proname);
        brandName = findViewById(R.id.hint_brandname);
        productType = findViewById(R.id.etPropertyTitle);
        quantity = findViewById(R.id.hint_quantity);
        Spinner spinner = findViewById(R.id.units);
        price = findViewById(R.id.price_hint);
        discount = findViewById(R.id.discount_hint);
        keyFeatures = findViewById(R.id.features_hint);
        precautions = findViewById(R.id.precautions_hint);
        technicalDetails = findViewById(R.id.technical_details);
        uploadIcon = findViewById(R.id.upload_icon);
        addProductBtn = findViewById(R.id.getStartedBtn);

        // Set up image picker
        uploadIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        // Handle product addition
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Product Image"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                uploadIcon.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void addProduct() {
        String name = productName.getText().toString().trim();
        String brand = brandName.getText().toString().trim();
        String type = productType.getText().toString().trim();
        String qty = quantity.getText().toString().trim();
        String unit = spinner.getSelectedItem().toString().trim();
        String prodPrice = price.getText().toString().trim();
        String prodDiscount = discount.getText().toString().trim();
        String features = keyFeatures.getText().toString().trim();
        String safety = precautions.getText().toString().trim();
        String technical = technicalDetails.getText().toString().trim();

        if (name.isEmpty() || brand.isEmpty() || type.isEmpty() || qty.isEmpty() || unit.isEmpty() || prodPrice.isEmpty() || prodDiscount.isEmpty() || features.isEmpty() || safety.isEmpty() || technical.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: Add logic to upload data to the database or server

        Toast.makeText(this, "Product added successfully!", Toast.LENGTH_SHORT).show();
    }
}