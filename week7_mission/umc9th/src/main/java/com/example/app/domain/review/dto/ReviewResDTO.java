package com.example.app.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

public class ReviewResDTO {

    @Getter
    @Builder
    public static class ReviewInfo {
        private Long id;
        private String content;
        private Integer score;
        private String storeName;
        private String memberName;
    }
}
