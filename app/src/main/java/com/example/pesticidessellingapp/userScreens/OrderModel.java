package com.example.pesticidessellingapp.userScreens;

public class OrderModel {
    private String orderId;
    private String orderDate;
    private String status;
    private String productName;
    private int quantity;
    private double price;
    private int productImage;

    public OrderModel(String orderId, String orderDate, String status,
                      String productName, int quantity, double price, int productImage) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productImage = productImage;
    }

    public String getOrderId() { return orderId; }
    public String getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public int getProductImage() { return productImage; }
}
