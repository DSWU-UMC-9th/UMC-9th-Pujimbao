package com.example.app.domain.review.service;

import com.example.app.domain.member.entity.Member;
import com.example.app.domain.member.repository.MemberRepository;
import com.example.app.domain.review.dto.ReviewRequest;
import com.example.app.domain.review.entity.Review;
import com.example.app.domain.review.repository.ReviewRepository;
import com.example.app.domain.store.entity.Store;
import com.example.app.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void createReview(Long memberId, Long storeId, ReviewRequest request) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .star(request.getRating())
                .content(request.getContent())
                .build();

        reviewRepository.save(review);
    }
}
