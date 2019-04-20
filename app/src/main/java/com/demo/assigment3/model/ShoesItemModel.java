package com.demo.assigment3.model;

import com.google.gson.annotations.SerializedName;

public class ShoesItemModel {

    @SerializedName("SF_COLOR")
    String color;
    @SerializedName("SF_MODEL")
    String model;
    @SerializedName("SF_SIZE")
    String size;
    @SerializedName("SF_TOTAL_STEPCOUNT_CAPACITY")
    String totalStepCountCapacity;
    @SerializedName("SF_GENDER")
    String gender;
    @SerializedName("SF_CREATED_DATE")
    String createdDate;
    @SerializedName("SF_SHOE_SKU_ID")
    String shoeID;
    @SerializedName("SF_MANUFACTURER")
    String manufacturer;
    @SerializedName("SF_ISREGISTERED")
    String isRegistered;
    @SerializedName("SF_IMAGE_LINK")
    String imageUrl;
    @SerializedName("SF_NAME")
    String name;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotalStepCountCapacity() {
        return totalStepCountCapacity;
    }

    public void setTotalStepCountCapacity(String totalStepCountCapacity) {
        this.totalStepCountCapacity = totalStepCountCapacity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getShoeID() {
        return shoeID;
    }

    public void setShoeID(String shoeID) {
        this.shoeID = shoeID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(String isRegistered) {
        this.isRegistered = isRegistered;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
