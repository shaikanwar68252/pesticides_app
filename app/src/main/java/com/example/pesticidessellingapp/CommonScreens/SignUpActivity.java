package com.example.pesticidessellingapp.CommonScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.ApiRequest.UserSignupRequest;
import com.example.pesticidessellingapp.ApiResponse.SignupResponse;
import com.example.pesticidessellingapp.Auth.LoginActivity;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.api.ApiClient;
import com.example.pesticidessellingapp.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhoneNumber, etPassword, etConfirmPassword;
    private Button btnSubmit;
    private CheckBox cbTerms;  // Added CheckBox
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        // Initialize UI components
        etName = findViewById(R.id.editTextText);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        cbTerms = findViewById(R.id.cbTerms);  // Initialize CheckBox
        btnSubmit = findViewById(R.id.btnSignUp);



        apiService = ApiClient.getClient().create(ApiService.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignUpActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else if (!cbTerms.isChecked()) {
                    Toast.makeText(SignUpActivity.this, "Please accept the terms and conditions!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(name, email, phoneNumber, password, confirmPassword);
                }
            }
        });
    }

    private void registerUser(String name, String email, String phoneNumber, String password, String confirmPassword) {
        UserSignupRequest user = new UserSignupRequest(name, email, phoneNumber, password, confirmPassword);
        Call<SignupResponse> call = apiService.signupUser(user);

        call.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if ("success".equals(response.body().getStatus())) {
                        Toast.makeText(SignUpActivity.this, "SignUp Successful!", Toast.LENGTH_SHORT).show();

                        // Navigate to the next activity
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "SignUp Failed: " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "Response Error!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
