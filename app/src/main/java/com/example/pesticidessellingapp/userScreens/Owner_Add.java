package com.example.pesticidessellingapp.userScreens;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

public class Owner_Add extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PICK_DOCUMENT_REQUEST = 2;

    private EditText ownerName, contactDetails, location, sizeModel, rentalPrice;
    private RadioGroup typeSelection;
    private Button uploadImageBtn, uploadDocumentBtn, submitBtn;
    private ImageView imagePreview;
    private TextView documentStatus;

    private Uri selectedImageUri;
    private Uri selectedDocumentUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_add);

        // Initialize UI elements
        ownerName = findViewById(R.id.owner_name);
        contactDetails = findViewById(R.id.contact_details);
        location = findViewById(R.id.location);
        sizeModel = findViewById(R.id.size_model);
        rentalPrice = findViewById(R.id.rental_price);
        typeSelection = findViewById(R.id.type_selection);

        uploadImageBtn = findViewById(R.id.upload_image);
        uploadDocumentBtn = findViewById(R.id.upload_document);
        submitBtn = findViewById(R.id.submit_button);

        imagePreview = findViewById(R.id.image_preview);
        documentStatus = findViewById(R.id.document_status);

        // Image Upload Handler
        uploadImageBtn.setOnClickListener(v -> openFileChooser(PICK_IMAGE_REQUEST));

        // Document Upload Handler
        uploadDocumentBtn.setOnClickListener(v -> openFileChooser(PICK_DOCUMENT_REQUEST));

        // Submit Button Handler
        submitBtn.setOnClickListener(v -> submitForm());
    }

    // Function to open file chooser
    private void openFileChooser(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        if (requestCode == PICK_IMAGE_REQUEST) {
            intent.setType("image/*");
        } else if (requestCode == PICK_DOCUMENT_REQUEST) {
            intent.setType("application/pdf");  // Allows only PDF files
        }
        startActivityForResult(intent, requestCode);
    }

    // Handle Image & Document Selection
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri fileUri = data.getData();

            if (requestCode == PICK_IMAGE_REQUEST) {
                selectedImageUri = fileUri;
                imagePreview.setImageURI(selectedImageUri);
                imagePreview.setVisibility(View.VISIBLE);
            } else if (requestCode == PICK_DOCUMENT_REQUEST) {
                selectedDocumentUri = fileUri;
                documentStatus.setText("Document Selected");
                documentStatus.setVisibility(View.VISIBLE);
            }
        }
    }

    // Function to submit form
    private void submitForm() {
        String owner = ownerName.getText().toString().trim();
        String contact = contactDetails.getText().toString().trim();
        String loc = location.getText().toString().trim();
        String sizeOrModel = sizeModel.getText().toString().trim();
        String price = rentalPrice.getText().toString().trim();

        int selectedTypeId = typeSelection.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedTypeId);
        String type = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";

        // Validation
        if (owner.isEmpty() || contact.isEmpty() || loc.isEmpty() || sizeOrModel.isEmpty() || price.isEmpty() || type.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedImageUri == null) {
            Toast.makeText(this, "Please upload an image", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedDocumentUri == null) {
            Toast.makeText(this, "Please upload a document", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process the form submission
        Toast.makeText(this, "Rental Added Successfully!", Toast.LENGTH_LONG).show();

        // TODO: Send data to Firebase or backend database
    }
}
