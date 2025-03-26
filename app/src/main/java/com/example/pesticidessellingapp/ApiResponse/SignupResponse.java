package com.example.pesticidessellingapp.ApiResponse;


public class SignupResponse {
    private boolean status; // Changed to boolean to match the API response
    private String message;
    private UserData data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public UserData getData() {
        return data;
    }

    public static class UserData {
        private int userId;
        private String email;
        private String phone;
        private String userType;

        public int getUserId() {
            return userId;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getUserType() {
            return userType;
        }
    }
}


