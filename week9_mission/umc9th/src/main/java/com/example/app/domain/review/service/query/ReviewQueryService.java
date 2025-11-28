package com.example.app.domain.review.service.query;

import com.example.app.domain.review.converter.ReviewConverter;
import com.example.app.domain.review.dto.ReviewResDTO;
import com.example.app.domain.review.entity.Review;
import com.example.app.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public ReviewResDTO.ReviewPreViewListDTO findReview(String storeName, Integer page) {

        PageRequest pageable = PageRequest.of(page, 10); // page는 0-based (Resolver가 조정해줌)

        Page<Review> result = reviewRepository.findByStore_Name(storeName, pageable);

        return ReviewConverter.toReviewPreViewListDTO(result);
    }

    public ReviewResDTO.ReviewPreViewListDTO findMyReviews(Long memberId, Integer page) {

        PageRequest pageable = PageRequest.of(page, 10); // page는 Resolver가 0-base로 변환

        Page<Review> result = reviewRepository.findByMember_Id(memberId, pageable);

        return ReviewConverter.toReviewPreViewListDTO(result);
    }

}
