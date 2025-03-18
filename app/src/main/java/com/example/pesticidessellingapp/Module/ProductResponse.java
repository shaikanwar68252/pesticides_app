package com.example.pesticidessellingapp.Module;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;

public class ProductResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("products")
    private List<Product> products;

    public String getStatus() {
        return status;
    }

    public Collection<? extends Product> getProducts() {
        return products;
    }
}
