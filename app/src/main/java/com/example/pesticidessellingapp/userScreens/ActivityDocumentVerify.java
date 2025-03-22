package com.example.pesticidessellingapp.userScreens;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

public class ActivityDocumentVerify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_verify);

        // Back Button Click Event
        ImageButton backButton = findViewById(R.id.backArrow_rentals);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDocumentVerify.this, Tractors_Details2.class); // Change to your previous activity
                startActivity(intent);
                finish();
            }
        });

        // View Full Document Buttons
        Button viewDoc1 = findViewById(R.id.uploadDocumentsBtn1);
        Button viewDoc2 = findViewById(R.id.uploadDocumentsBtn2);
        Button viewDoc3 = findViewById(R.id.uploadDocumentsBtn);
        Button proceedToRent = findViewById(R.id.proceedto_rent);

        viewDoc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDocumentVerify.this, ActivityDocumentVerify.class); // Change to your document viewing activity
                startActivity(intent);
            }
        });

        viewDoc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDocumentVerify.this, ActivityDocumentVerify.class);
                startActivity(intent);
            }
        });

        viewDoc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDocumentVerify.this, ActivityDocumentVerify.class);
                startActivity(intent);
            }
        });

        // Proceed to Rent Button Click Event
        proceedToRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDocumentVerify.this, ActivityDocumentVerify.class); // Change to your rent process activity
                startActivity(intent);
            }
        });
    }
}
