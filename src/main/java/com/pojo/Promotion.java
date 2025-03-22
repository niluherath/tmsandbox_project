package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Promotion {

    @JsonProperty("Id")
    public int id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Price")
    public int price;
    @JsonProperty("MinimumPhotoCount")
    public int minimumPhotoCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinimumPhotoCount() {
        return minimumPhotoCount;
    }

    public void setMinimumPhotoCount(int minimumPhotoCount) {
        this.minimumPhotoCount = minimumPhotoCount;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    @JsonProperty("OriginalPrice")
    public int originalPrice;
    @JsonProperty("Recommended")
    public boolean recommended;


}
