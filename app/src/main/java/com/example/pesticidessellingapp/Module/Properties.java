package com.example.pesticidessellingapp.Module;

import android.os.Parcel;
import android.os.Parcelable;

public class Properties implements Parcelable {

    private String id;
    private String type;
    private String title;
    private String location;
    private String area_size;
    private String rate_per_day;
    private String description;
    private String image_path;
    private String model;
    private String engine_power;
    private String fuel_type;
    private String capacity;
    private String year;
    private String technical_details;
    private String features;
    private String rental_terms;
    private String available_from;
    private String created_at;

    // --- Empty Constructor ---
    public Properties() {}

    // --- Parcelable Constructor ---
    protected Properties(Parcel in) {
        id = in.readString();
        type = in.readString();
        title = in.readString();
        location = in.readString();
        area_size = in.readString();
        rate_per_day = in.readString();
        description = in.readString();
        image_path = in.readString();
        model = in.readString();
        engine_power = in.readString();
        fuel_type = in.readString();
        capacity = in.readString();
        year = in.readString();
        technical_details = in.readString();
        features = in.readString();
        rental_terms = in.readString();
        available_from = in.readString();
        created_at = in.readString();
    }

    // --- Parcelable Methods ---
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(location);
        dest.writeString(area_size);
        dest.writeString(rate_per_day);
        dest.writeString(description);
        dest.writeString(image_path);
        dest.writeString(model);
        dest.writeString(engine_power);
        dest.writeString(fuel_type);
        dest.writeString(capacity);
        dest.writeString(year);
        dest.writeString(technical_details);
        dest.writeString(features);
        dest.writeString(rental_terms);
        dest.writeString(available_from);
        dest.writeString(created_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Properties> CREATOR = new Creator<Properties>() {
        @Override
        public Properties createFromParcel(Parcel in) {
            return new Properties(in);
        }

        @Override
        public Properties[] newArray(int size) {
            return new Properties[size];
        }
    };

    // --- Getters and Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea_size() {
        return area_size;
    }

    public void setArea_size(String area_size) {
        this.area_size = area_size;
    }

    public String getRate_per_day() {
        return rate_per_day;
    }

    public void setRate_per_day(String rate_per_day) {
        this.rate_per_day = rate_per_day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine_power() {
        return engine_power;
    }

    public void setEngine_power(String engine_power) {
        this.engine_power = engine_power;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTechnical_details() {
        return technical_details;
    }

    public void setTechnical_details(String technical_details) {
        this.technical_details = technical_details;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getRental_terms() {
        return rental_terms;
    }

    public void setRental_terms(String rental_terms) {
        this.rental_terms = rental_terms;
    }

    public String getAvailable_from() {
        return available_from;
    }

    public void setAvailable_from(String available_from) {
        this.available_from = available_from;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
