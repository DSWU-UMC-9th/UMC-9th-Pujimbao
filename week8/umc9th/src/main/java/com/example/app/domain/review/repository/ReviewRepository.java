package com.example.app.domain.review.repository;

import com.example.app.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {

    List<Review> findByMember_Id(Long memberId);      // 내가 쓴 리뷰
    List<Review> findByStore_Id(Long storeId);        // 특정 가게 리뷰
}
