package com.example.app.domain.review.converter;

import com.example.app.domain.review.dto.res.ReviewResDTO;
import com.example.app.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResDTO.ReviewInfo toReviewInfo(Review review) {
        return ReviewResDTO.ReviewInfo.builder()
                .id(review.getId())
                .content(review.getContent())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .memberName(review.getMember().getName())
                .build();
    }

    public static List<ReviewResDTO.ReviewInfo> toReviewInfoList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toReviewInfo)
                .collect(Collectors.toList());
    }
}
