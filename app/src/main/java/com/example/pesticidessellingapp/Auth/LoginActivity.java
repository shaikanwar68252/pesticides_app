package com.example.pesticidessellingapp.Auth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.adminScreens.AdminDashboard;
import com.example.pesticidessellingapp.CommonScreens.SignUpActivity;
import com.example.pesticidessellingapp.databinding.ActivityLoginBinding;
import com.example.pesticidessellingapp.userScreens.UserDashboardActivity;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.loginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, UserDashboardActivity.class);
            startActivity(intent);
        });

        binding.signUpText.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}
