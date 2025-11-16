package com.example.app.domain.review.controller;

import com.example.app.domain.review.dto.ReviewRequest;
import com.example.app.domain.review.service.ReviewService;
import com.example.app.global.ApiResponse;
import com.example.app.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class ReviewController {

    private final ReviewService reviewService;
    private final Long FIXED_USER_ID = 1L; // 하드코딩 유저

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<Void> createReview(
            @PathVariable Long storeId,
            @RequestBody ReviewRequest request
    ) {
        reviewService.createReview(FIXED_USER_ID, storeId, request);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK,null);
    }
}
