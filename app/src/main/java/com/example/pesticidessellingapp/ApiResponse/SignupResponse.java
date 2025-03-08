package com.example.pesticidessellingapp.ApiResponse;

public class SignupResponse {
    private String status; // Change from boolean to String to match API response
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

