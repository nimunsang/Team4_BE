package com.ktc.matgpt.domain.store;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.ktc.matgpt.domain.store.entity.SubCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class StoreRequest {

    @Setter
    @Getter
    @NoArgsConstructor
    public static class AddStoreDto {
        String address;
        Long subCategoryId;
        String name;
        String phoneNumber;
        String businessHours;
        String storeImageUrl;
        Double latitude;
        Double longitude;
        int avgCostPerPerson;
        double avgVisitCount;
        int numsOfReview;
        double avgRating;

        public AddStoreDto(String address, Long subCategoryId, String name, String phoneNumber, String businessHours, String storeImageUrl, Double latitude, Double longitude, int avgCostPerPerson, double avgVisitCount, int numsOfReview, double avgRating) {
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

    @Setter
    @Getter
    @NoArgsConstructor
    public static class UpdateStoreImageDto {
        String imageUrl;

        public UpdateStoreImageDto(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class UpdateStoreNameDto {
        String name;

        public UpdateStoreNameDto(String name) {
            this.name = name;
        }
    }
}
