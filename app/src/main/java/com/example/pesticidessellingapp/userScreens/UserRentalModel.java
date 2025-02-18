package com.example.pesticidessellingapp.userScreens;

public class UserRentalModel {
    private String productName;
    private String productImage;
    private String productPrice;

    public UserRentalModel() {
    }

    public UserRentalModel(String productName, String productImage, String productPrice) {
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
