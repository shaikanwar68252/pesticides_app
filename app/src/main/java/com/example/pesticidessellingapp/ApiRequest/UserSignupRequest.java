package com.example.pesticidessellingapp.ApiRequest;

public class UserSignupRequest {
    private String name;
    private String email;
    private String phone_number;
    private String password;
    private String confirm_password;


    public UserSignupRequest(String name, String email, String phone_number, String password, String confirm_password) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    // Getters for JSON serialization
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone_number() { return phone_number; }
    public String getPassword() { return password; }
    public String getConfirm_password() { return confirm_password; }
}
