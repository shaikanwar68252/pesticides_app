package com.example.pesticidessellingapp.Module;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable {
    @SerializedName("id")
    private String id;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("brand")
    private String brand;

    @SerializedName("price")
    private String price;

    @SerializedName("discount")
    private String discount;

    @SerializedName("stock_status")
    private String stockStatus;

    @SerializedName("quantity_available")
    private String quantityAvailable;

    @SerializedName("unit")
    private String unit;

    @SerializedName("description")
    private String description;

    @SerializedName("key_features")
    private String keyFeatures;

    @SerializedName("safety_precautions")
    private String safetyPrecautions;

    @SerializedName("technical_specifications")
    private String technicalSpecifications;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("created_at")
    private String createdAt;

    // Empty Constructor
    public Product() {}

    protected Product(Parcel in) {
        id = in.readString();
        productName = in.readString();
        brand = in.readString();
        price = in.readString();
        discount = in.readString();
        stockStatus = in.readString();
        quantityAvailable = in.readString();
        unit = in.readString();
        description = in.readString();
        keyFeatures = in.readString();
        safetyPrecautions = in.readString();
        technicalSpecifications = in.readString();
        imageUrl = in.readString();
        createdAt = in.readString();
    }

    // 🔥 Fix: Make CREATOR `static`
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(productName);
        dest.writeString(brand);
        dest.writeString(price);
        dest.writeString(discount);
        dest.writeString(stockStatus);
        dest.writeString(quantityAvailable);
        dest.writeString(unit);
        dest.writeString(description);
        dest.writeString(keyFeatures);
        dest.writeString(safetyPrecautions);
        dest.writeString(technicalSpecifications);
        dest.writeString(imageUrl);
        dest.writeString(createdAt);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public String getQuantityAvailable() {
        return quantityAvailable;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public String getKeyFeatures() {
        return keyFeatures;
    }

    public String getSafetyPrecautions() {
        return safetyPrecautions;
    }

    public String getTechnicalSpecifications() {
        return technicalSpecifications;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
