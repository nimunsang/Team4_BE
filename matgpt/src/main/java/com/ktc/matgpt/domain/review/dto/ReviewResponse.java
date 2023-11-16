package com.ktc.matgpt.domain.review.dto;

import com.ktc.matgpt.domain.image.Image;
import com.ktc.matgpt.domain.review.entity.Review;
import com.ktc.matgpt.domain.tag.Tag;
import lombok.*;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewResponse {

    @Getter
    @ToString
    public static class UploadS3DTO {
        private Long reviewId;
        private List<PresignedUrlDTO> presignedUrls;

        public UploadS3DTO(Long reviewId, List<PresignedUrlDTO> presignedUrls) {
            this.reviewId = reviewId;
            this.presignedUrls = presignedUrls;
        }

        @Getter
        @ToString
        public static class PresignedUrlDTO {
            private URL presignedUrl;

            @Builder
            public PresignedUrlDTO(URL presignedUrl) {
                this.presignedUrl = presignedUrl;
            }
        }
    }


    @Getter
    @ToString
    public static class FindByReviewIdDTO {
        private Long storeId;
        private Long reviewId;
        private ReviewerDTO reviewer;
        private int averageCostPerPerson;
        private int peopleCount;
        private String createdAt;
        private int rating;
        private int recommendCount;
        private String content;
        private List<FindByReviewIdDTO.ImageDTO> reviewImages;
        private int totalPrice;     // 범위로 받게 된다면 enum PriceRange 타입 이용
        private boolean updated = false;
        private boolean owner;

        public FindByReviewIdDTO(Review review, ReviewerDTO reviewer, List<ImageDTO> reviewImages, String relativeTime, boolean owner) {
            this.storeId = review.getStore().getId();
            this.reviewId = review.getId();
            this.reviewer = reviewer;
            this.reviewImages = reviewImages;
            this.content = review.getContent();
            this.rating = review.getRating();
            this.recommendCount = review.getRecommendCount();
            this.peopleCount = review.getPeopleCount();
            this.totalPrice = review.getTotalPrice();
            this.averageCostPerPerson = review.getCostPerPerson();
            this.createdAt = relativeTime;
//            if (review.getCreatedAt() != review.getUpdatedAt()) this.updated = true;
            this.owner = owner;
        }

        @Getter
        @ToString
        public static class ReviewerDTO {
            private String profileImage;
            private String userName;
            private String email;

            @Builder
            public ReviewerDTO(String profileImage, String userName, String email) {
                this.profileImage = profileImage;
                this.userName = userName;
                this.email = email;
            }
        }

        @Getter
        @ToString
        public static class ImageDTO {
            private String image;
            private List<ImageDTO.TagDTO> tags;
            public ImageDTO(Image image, List<Tag> tags) {
                this.image = image.getUrl();
                this.tags = tags.stream()
                        .map(t -> new TagDTO(t))
                        .collect(Collectors.toList());
            }

            @Getter
            @ToString
            public static class TagDTO {
                private String name;
                private double location_x;
                private double location_y;
                private int rating;

                public TagDTO(Tag tag) {
                    this.name = tag.getFood().getFoodName();
                    this.location_x = tag.getLocationX();
                    this.location_y = tag.getLocationY();
                    this.rating = tag.getMenuRating();
                }
            }
        }
    }


    @Getter
    @ToString
    public static class StoreReviewDTO {
        private Long reviewId;
        private int rating;
        private String content;
        private LocalDateTime createdAt;
        private String imageUrl;
        private boolean updated = false;
        private String relativeTime;
        private int numOfLikes;

        public StoreReviewDTO(Review review, String relativeTime, String imageUrl) {
            this.reviewId = review.getId();
            this.imageUrl = imageUrl;
            this.content = review.getContent();
            this.rating = review.getRating();
            this.createdAt = review.getCreatedAt();
            this.relativeTime = relativeTime;
            this.numOfLikes = review.getRecommendCount();

//            if (review.getCreatedAt() != review.getUpdatedAt()) this.updated = true;
        }
    }




    @Getter
    @ToString
    public static class UserReviewDTO {
            private Long id;
            private int rating;
            private String content;
            private LocalDateTime createdAt;
            private String storeImage;
            private String storeName;
            private String relativeTime;
            private boolean updated = false;
            private int numOfLikes;
            private int peopleCount;

            public UserReviewDTO(Review review, String relativeTime) {
                this.id = review.getId();
                this.rating = review.getRating();
                this.content = review.getContent();
                this.createdAt = review.getCreatedAt();
                this.storeImage = review.getStore().getStoreImageUrl();
                this.storeName = review.getStore().getName();
                this.relativeTime = relativeTime;
//                if (review.getCreatedAt() != review.getUpdatedAt()) this.updated = true;
                this.numOfLikes = review.getRecommendCount();
                this.peopleCount = review.getPeopleCount();
        }
    }

    @ToString
    @Getter
    public static class RecentReviewDTO {
        private Long id;
        private int rating;
        private String content;
        private LocalDateTime createdAt;
        private String storeImage;
        private String storeName;
        private String relativeTime;
        private int numOfLikes;
        private int peopleCount;

        public RecentReviewDTO(Review review, String relativeTime) {
            this.id = review.getId();
            this.rating = review.getRating();
            this.content = review.getContent();
            this.createdAt = review.getCreatedAt();
            this.storeImage = review.getStore().getStoreImageUrl();
            this.storeName = review.getStore().getName();
            this.relativeTime = relativeTime;
            this.numOfLikes = review.getRecommendCount();
            this.peopleCount = review.getPeopleCount();
        }
    }
}
