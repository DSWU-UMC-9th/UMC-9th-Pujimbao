package com.example.app.domain.review.controller;

import com.example.app.domain.review.dto.ReviewResDTO;
import com.example.app.domain.review.entity.Review;
import com.example.app.domain.review.exception.code.ReviewSuccessCode;
import com.example.app.domain.review.service.query.ReviewQueryService;
import com.example.app.global.ApiResponse;
import com.example.app.global.annotation.ValidPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class ReviewController implements ReviewControllerDocs{

    private final ReviewQueryService reviewQueryService;

    // 가게의 리뷰 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @ValidPage @RequestParam Integer page
    ) {
        return ApiResponse.onSuccess(
                ReviewSuccessCode.READ_REVIEW_SUCCESS,
                reviewQueryService.findReview(storeName, page)
        );
    }

    // 내가 작성한 리뷰 목록 조회
    @GetMapping("/reviews/me")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviews(
            @RequestParam Long memberId,
            @ValidPage @RequestParam Integer page
    ) {
        return ApiResponse.onSuccess(
                ReviewSuccessCode.READ_REVIEW_SUCCESS,
                reviewQueryService.findMyReviews(memberId, page)
        );
    }


}
