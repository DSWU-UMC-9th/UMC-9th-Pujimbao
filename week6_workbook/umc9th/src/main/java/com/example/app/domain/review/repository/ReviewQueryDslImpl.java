package com.example.app.domain.review.repository;

import com.example.app.domain.review.entity.QReview;
import com.example.app.domain.review.entity.Review;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl{

    private final EntityManager em;

    @Override
    public List<Review> searchReview(Predicate predicate) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QReview review = QReview.review;

//        BooleanBuilder builder = new BooleanBuilder();

//        if (name != null) {
//            builder.and(review.store.name.contains(name));
//        }
//
//        if (star != null) {
//            builder.and(review.star.gt(star));
//        }

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }

}
