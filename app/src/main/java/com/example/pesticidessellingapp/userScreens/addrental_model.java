package com.example.pesticidessellingapp.userScreens;

public class addrental_model {
    private String productName;
    private String productImage;
    private String productPrice;

    public addrental_model() {
    }

    public addrental_model(String productName, String productImage, String productPrice) {
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
