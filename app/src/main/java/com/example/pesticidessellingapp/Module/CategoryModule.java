package com.example.pesticidessellingapp.Module;

public class CategoryModule {

    private String imageUrl,CategoryName;

    public CategoryModule(String imageUrl, String categoryName) {
        this.imageUrl = imageUrl;
        CategoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategoryName() {
        return CategoryName;
    }
}
