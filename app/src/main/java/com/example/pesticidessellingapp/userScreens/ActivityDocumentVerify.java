package com.example.pesticidessellingapp.userScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pesticidessellingapp.R;

public class ActivityDocumentVerify extends AppCompatActivity {

    private Button proceedToRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_document_verify);

        // Initialize Button
        proceedToRent = findViewById(R.id.proceedto_rent);

        // Set Click Listener
        proceedToRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDocumentVerify.this, ProceedRent.class);
                startActivity(intent);
            }
        });

        // Handle Edge-to-Edge Display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_docsverify), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
