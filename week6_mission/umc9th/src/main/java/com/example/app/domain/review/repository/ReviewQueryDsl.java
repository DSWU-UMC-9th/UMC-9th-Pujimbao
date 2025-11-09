package com.example.app.domain.review.repository;

import com.example.app.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {
    List<Review> searchReview(Predicate predicate);
}
