
package com.example.pesticidessellingapp.userScreens;
public class Model_Home {

    private String name;
    private String imageUrl;
    private double price;

    public Model_Home(String name, String imageUrl, double price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }
}
