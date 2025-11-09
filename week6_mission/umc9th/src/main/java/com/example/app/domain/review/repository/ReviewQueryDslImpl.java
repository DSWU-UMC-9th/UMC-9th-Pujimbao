package com.example.app.domain.review.repository;

import com.example.app.domain.review.entity.QReview;
import com.example.app.domain.review.entity.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Predicate;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final EntityManager em;

    @Override
    public List<Review> searchReview(Predicate predicate) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }
}
