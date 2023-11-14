package com.ktc.matgpt.domain.store;

import com.ktc.matgpt.domain.store.entity.SubCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreRequest {

    private String address;
    private Long subCategoryId;
    private String name;
    private String phoneNumber;
    private String businessHours;
    private String storeImageUrl;
    private Double latitude;
    private Double longitude;
    private int avgCostPerPerson;
    private double avgVisitCount;
    private int numsOfReview;
    private double avgRating;

    public StoreRequest(String address, Long subCategoryId, String name, String phoneNumber, String businessHours, String storeImageUrl, Double latitude, Double longitude) {
        this.address = address;
        this.subCategoryId = subCategoryId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.businessHours = businessHours;
        this.storeImageUrl = storeImageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.avgCostPerPerson = 0;
        this.avgVisitCount = 0.0;
        this.numsOfReview = 0;
        this.avgRating = 0.0;
    }
}
