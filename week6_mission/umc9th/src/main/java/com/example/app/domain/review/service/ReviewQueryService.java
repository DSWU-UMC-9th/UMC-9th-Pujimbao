package com.example.app.domain.review.service;

import com.example.app.domain.review.entity.QReview;
import com.example.app.domain.review.entity.Review;
import com.example.app.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> getMyReviews(Long memberId, String storeName, Integer starRange) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();

        // 내가 쓴 리뷰만 필터링
        builder.and(review.member.id.eq(memberId));

        // 가게 이름 필터링
        if (storeName != null && !storeName.isEmpty()) {
            builder.and(review.store.name.contains(storeName));
        }

        // 별점대 필터링 (5점대, 4점대, 3점대...)
        if (starRange != null) {
            float min = starRange;
            float max = starRange + 0.9f;
            builder.and(review.star.between(min, max));
        }

        return reviewRepository.searchReview(builder);
    }
}
