package com.example.app.domain.review.repository;

import com.example.app.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {

    List<Review> findByMember_Id(Long memberId);      // 내가 쓴 리뷰
    List<Review> findByStore_Id(Long storeId);        // 특정 가게 리뷰
    Page<Review> findByMember_Id(Long memberId, Pageable pageable);
    Page<Review> findByStore_Name(String storeName, Pageable pageable);

}
