package com.example.pesticidessellingapp.ApiRequest;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("email_or_phone") // MUST match PHP field name
    private String emailOrPhone;

    @SerializedName("password") // MUST match PHP field name
    private String password;

    public LoginRequest(String emailOrPhone, String password) {
        this.emailOrPhone = emailOrPhone;
        this.password = password;
    }
}
