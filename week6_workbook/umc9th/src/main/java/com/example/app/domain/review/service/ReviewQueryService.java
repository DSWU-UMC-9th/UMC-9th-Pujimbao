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

    public List<Review> searchReview (String query, String type) {
        // Q클래스 정의
        QReview review = QReview.review;

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // BooleanBuilder 사용

        // 동적 쿼리: 검색 조건
        if (type.equals("location")) {
            builder.and(review.store.location.name.contains(query));
        }
        if (type.equals("star")) {
            builder.and(review.star.goe(Float.parseFloat(query)));
        }
        if (type.equals("both")) {
            // & 기준 변환
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            // 동적 쿼리
            builder.and(review.store.location.name.contains(firstQuery));
            builder.and(review.star.goe(Float.parseFloat(secondQuery)));
        }

        // Repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.searchReview(builder);

        // 리턴
        return reviewList;

    }


//    private final ReviewRepository reviewRepository;
//
//    public List<Review> searchReview(String name, Float star) {
//        QReview review = QReview.review;
//        BooleanBuilder builder = new BooleanBuilder();
//
//        if (name != null && !name.isEmpty()) {
//            builder.and(review.store.name.contains(name));
//        }
//
//        if (star != null) {
//            builder.and(review.star.goe(star));
//        }
//
//        return reviewRepository.searchReview(builder);
//    }

}
