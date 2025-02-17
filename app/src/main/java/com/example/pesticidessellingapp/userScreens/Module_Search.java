package com.example.pesticidessellingapp.userScreens;

public class Module_Search{
    private String productName;
    private String category;
    private String price;
    private String description;
    private String image;

    public Module_Search(String productName, String category, String price, String description, String image) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Module_Search(String agriculturalScientist, String category, String price) {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
