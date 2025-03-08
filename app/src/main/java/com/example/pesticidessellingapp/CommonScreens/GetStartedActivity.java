package com.example.pesticidessellingapp.CommonScreens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.Auth.LoginActivity;
import com.example.pesticidessellingapp.BaseActivity;
import com.example.pesticidessellingapp.databinding.ActivityGetStartedBinding;

import java.util.Locale;

public class GetStartedActivity extends BaseActivity {

    ActivityGetStartedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        binding = ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signInBtn.setOnClickListener(view -> {
            startActivity(new Intent(GetStartedActivity.this, LoginActivity.class));
        });

        binding.getStartedBtn.setOnClickListener(v -> {
            startActivity(new Intent(GetStartedActivity.this, SignUpActivity.class));
        });

    }


}