package com.example.pesticidessellingapp.userScreens;

public class pesticides_module_class {
    private static String name;
    private static String price;
    private static String imageUrl;

    public pesticides_module_class(String horairaNutz, String ₹755, String url) {
    }

    public void Product(String name, String price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public static String getName() { return name; }
    public static String getPrice() { return price; }
    public static String getImageUrl() { return imageUrl; }
}
