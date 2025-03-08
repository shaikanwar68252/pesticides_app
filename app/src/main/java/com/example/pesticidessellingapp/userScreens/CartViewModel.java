package com.example.pesticidessellingapp.userScreens;

public class CartViewModel {
    private String productName;
    private String category;
    private int imageResId; // Change from String to int for drawable resource
    private double price;
    private int quantity;

    public CartViewModel(String productName, String category, int imageResId, double price, int quantity) {
        this.productName = productName;
        this.category = category;
        this.imageResId = imageResId; // Store drawable resource ID
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public int getImageResId() {
        return imageResId; // Getter for drawable resource
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void decreaseQuantity() {
        if (this.quantity > 1) {
            this.quantity--;
        }
    }
}
