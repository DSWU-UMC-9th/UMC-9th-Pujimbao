package com.example.app.domain.review.controller;

import com.example.app.domain.review.entity.Review;
import com.example.app.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/my")
    public List<Review> getMyReviews(
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starRange,
            @RequestParam Long memberId  // 로그인 기능 없으므로 임시 전달
    ) {
        return reviewQueryService.getMyReviews(memberId, storeName, starRange);
    }
}
