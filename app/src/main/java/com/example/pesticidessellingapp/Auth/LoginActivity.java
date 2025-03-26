package com.example.pesticidessellingapp.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.ApiRequest.LoginRequest;
import com.example.pesticidessellingapp.ApiResponse.LoginResponse;
import com.example.pesticidessellingapp.IpV4Connection;
import com.example.pesticidessellingapp.adminScreens.AdminDashboard;
import com.example.pesticidessellingapp.api.ApiClient;
import com.example.pesticidessellingapp.api.ApiService;
import com.example.pesticidessellingapp.databinding.ActivityLoginBinding;
import com.example.pesticidessellingapp.userScreens.UserDashboardActivity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity"; // Debugging tag
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBtn.setOnClickListener(v -> {
            String emailOrPhone = binding.editTextText.getText().toString().trim();
            String password = binding.editTextTextPassword.getText().toString().trim();

            if (emailOrPhone.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            letUserLogin(emailOrPhone, password);
            Log.d(TAG, "Login button clicked with: " + emailOrPhone);
        });

        binding.signUpText.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, UserDashboardActivity.class));
        });
    }

    private void letUserLogin(String emailOrPhone, String password) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);



        Call<LoginResponse> call = apiService.loginUser(new LoginRequest(emailOrPhone, password));

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LoginResponse loginResponse = response.body();

                    if (loginResponse.isStatus()) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        if (loginResponse.getData().getUserType().equalsIgnoreCase("Admin")) {
                            startActivity(new Intent(LoginActivity.this, AdminDashboard.class));
                        } else {
                            startActivity(new Intent(LoginActivity.this, UserDashboardActivity.class));
                        }
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Login Error: " + t.getMessage());
            }
        });
    }
}

