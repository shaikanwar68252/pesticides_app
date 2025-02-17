package com.example.pesticidessellingapp.api;

import com.example.pesticidessellingapp.ApiResponse.SignupResponse;
import com.example.pesticidessellingapp.ApiRequest.UserSignupRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

 public interface ApiService {
    @Headers({"Content-Type: application/json"})
    @POST("signup.php")
    Call<SignupResponse> signupUser
    (@Body UserSignupRequest user);
}
