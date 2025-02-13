package com.example.pesticidessellingapp;

public class User1 {
    private String name;
    private String email;
    private String password;

    public User1(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters for Retrofit serialization
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
