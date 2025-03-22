package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Fees {

    @JsonProperty("Bundle")
    public int bundle;
    @JsonProperty("EndDate")
    public double endDate;

    public int getBundle() {
        return bundle;
    }

    public void setBundle(int bundle) {
        this.bundle = bundle;
    }

    public double getEndDate() {
        return endDate;
    }

    public void setEndDate(double endDate) {
        this.endDate = endDate;
    }

    public int getFeature() {
        return feature;
    }

    public void setFeature(int feature) {
        this.feature = feature;
    }

    public int getGallery() {
        return gallery;
    }

    public void setGallery(int gallery) {
        this.gallery = gallery;
    }

    public int getListing() {
        return listing;
    }

    public void setListing(int listing) {
        this.listing = listing;
    }

    public double getReserve() {
        return reserve;
    }

    public void setReserve(double reserve) {
        this.reserve = reserve;
    }

    public double getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(double subtitle) {
        this.subtitle = subtitle;
    }

    public double getTenDays() {
        return tenDays;
    }

    public void setTenDays(double tenDays) {
        this.tenDays = tenDays;
    }

    public ArrayList<ListingFeeTier> getListingFeeTiers() {
        return listingFeeTiers;
    }

    public void setListingFeeTiers(ArrayList<ListingFeeTier> listingFeeTiers) {
        this.listingFeeTiers = listingFeeTiers;
    }

    public double getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(double secondCategory) {
        this.secondCategory = secondCategory;
    }

    @JsonProperty("Feature")
    public int feature;
    @JsonProperty("Gallery")
    public int gallery;
    @JsonProperty("Listing")
    public int listing;
    @JsonProperty("Reserve")
    public double reserve;
    @JsonProperty("Subtitle")
    public double subtitle;
    @JsonProperty("TenDays")
    public double tenDays;
    @JsonProperty("ListingFeeTiers")
    public ArrayList<ListingFeeTier> listingFeeTiers;
    @JsonProperty("SecondCategory")
    public double secondCategory;



}
