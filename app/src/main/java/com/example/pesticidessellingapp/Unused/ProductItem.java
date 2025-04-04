package com.example.pesticidessellingapp.Unused;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pesticidessellingapp.CommonScreens.SignUpActivity;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.userScreens.UserDashboardActivity;

public class ProductItem {

    int imageResource;
    String productName;
    String price;

    public ProductItem(int imageResource, String productName, String price) {
        this.imageResource = imageResource;
        this.productName = productName;
        this.price = price;
    }

    public static class UserLoginActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_user_page);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            EditText emailEditText = findViewById(R.id.editTextText);
            EditText passwordEditText = findViewById(R.id.editTextTextPassword);
            Button loginButton = findViewById(R.id.Login);
            TextView signUpText = findViewById(R.id.signUpText);


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailEditText.getText().toString().trim();
                    String password = passwordEditText.getText().toString().trim();

                    // Perform login validation (this is just a placeholder logic)
                    if (!email.isEmpty() && !password.isEmpty()) {
                        Intent intent = new Intent(UserLoginActivity.this, UserDashboardActivity.class);
                        startActivity(intent);
                    } else {
                        emailEditText.setError("Enter a valid email");
                        passwordEditText.setError("Enter a valid password");
                    }
                }
            });

            signUpText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UserLoginActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}
