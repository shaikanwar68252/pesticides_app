package com.example.pesticidessellingapp.userScreens;

public class cartview_model {
    private String productName;
    private double price;
    private int quantity;
    private String imageUrl;

    public cartview_model(String productName, double price, int quantity, String imageUrl) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getImageUrl() { return imageUrl; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
