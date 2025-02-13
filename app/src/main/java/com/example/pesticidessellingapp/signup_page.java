package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signup_page extends AppCompatActivity {

    private EditText etName, etEmailPhone, editTextTextPassword;
    private Button btnSubmit;
    private ApiService apiService;  // ✅ Use lowercase variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        // Initialize UI components
        etName = findViewById(R.id.etName);
        etEmailPhone = findViewById(R.id.etEmailPhone);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.185.128/Pesticides/") // Change this to your server URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);  // ✅ Correct instance

        // Set up button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String emailOrPhone = etEmailPhone.getText().toString();
                String password = editTextTextPassword.getText().toString();

                if (name.isEmpty() || emailOrPhone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signup_page.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(name, emailOrPhone, password);
                }
            }
        });
    }

    private void registerUser(String name, String email, String password) {
        User1 user = new User1(name, email, password);
        Call<RetrofitAPIRequest> call = apiService.signupUser(user);  // ✅ Corrected API call

        call.enqueue(new Callback<RetrofitAPIRequest>() {
            @Override
            public void onResponse(Call<RetrofitAPIRequest> call, Response<RetrofitAPIRequest> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().isSuccess()) {
                        Toast.makeText(signup_page.this, "Signup Successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(signup_page.this, "Signup Failed: " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(signup_page.this, "Response Error!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RetrofitAPIRequest> call, Throwable t) {
                Toast.makeText(signup_page.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
