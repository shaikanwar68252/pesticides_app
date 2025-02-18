package com.example.pesticidessellingapp.CommonScreens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.ApiRequest.UserSignupRequest;
import com.example.pesticidessellingapp.ApiResponse.SignupResponse;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    private EditText etName, etEmailPhone, editTextTextPassword;
    private Button btnSubmit;
    private ApiService apiService;  // ✅ Use lowercase variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

//        // Initialize UI components
//        etName = findViewById(R.id.etName);
//        etEmailPhone = findViewById(R.id.etEmailPhone);
//        editTextTextPassword = findViewById(R.id.editTextTextPassword);
//        btnSubmit = findViewById(R.id.btnSubmit);
//
//        // Initialize Retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.185.128/Pesticides/") // Change this to your server URL
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        apiService = retrofit.create(ApiService.class);  // ✅ Correct instance
//
//        // Set up button click listener
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = etName.getText().toString();
//                String emailOrPhone = etEmailPhone.getText().toString();
//                String password = editTextTextPassword.getText().toString();
//
//                if (name.isEmpty() || emailOrPhone.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//                } else {
//                    registerUser(name, emailOrPhone, password);
//                }
//            }
//        });
//    }
//
//    private void registerUser(String name, String email, String password) {
//        UserSignupRequest user = new UserSignupRequest(name, email, password);
//        Call<SignupResponse> call = apiService.signupUser(user);  // ✅ Corrected API call
//
//        call.enqueue(new Callback<SignupResponse>() {
//            @Override
//            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    if (response.body().isSuccess()) {
//                        Toast.makeText(SignUpActivity.this, "Signup Successful!", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(SignUpActivity.this, "Signup Failed: " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(SignUpActivity.this, "Response Error!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SignupResponse> call, Throwable t) {
//                Toast.makeText(SignUpActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//
    }
}
