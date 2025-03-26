package com.example.pesticidessellingapp.ApiRequest;

public class UserSignupRequest {
    private String name;
    private String email;
    private String mobile_no;
    private String password;


    public UserSignupRequest(String name, String email, String phone_number, String password) {
        this.name = name;
        this.email = email;
        this.mobile_no = phone_number;
        this.password = password;
    }

    // Getters for JSON serialization
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile_no() { return mobile_no; }
    public String getPassword() { return password; }
}
