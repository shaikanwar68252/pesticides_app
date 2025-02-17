package com.example.pesticidessellingapp.ApiRequest;

public class UserSignupRequest {
    private String name;
    private String email;
    private String password;

    public UserSignupRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters for Retrofit serialization
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
