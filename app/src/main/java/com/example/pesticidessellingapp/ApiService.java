package com.example.pesticidessellingapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

 interface ApiService {
    @Headers({"Content-Type: application/json"})
    @POST("signup.php")
    Call<RetrofitAPIRequest> signupUser
    (@Body User1 user);
}
