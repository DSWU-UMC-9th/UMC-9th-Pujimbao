//package com.example.app.domain.review.controller;
//
//import com.example.app.domain.review.entity.Review;
//import com.example.app.domain.review.service.ReviewQueryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api")
//public class ReviewController {
//
//    private final ReviewQueryService reviewService;
//
//    @GetMapping("/reviews/search")
//    public List<Review> searchReview(
//            @RequestParam String query,
//            @RequestParam String type
//    ) {
//        return reviewService.searchReview(query, type);
//    }
//}

package com.example.app.domain.review.controller;

import com.example.app.domain.review.converter.ReviewConverter;
import com.example.app.domain.review.dto.res.ReviewResDTO;
import com.example.app.domain.review.service.ReviewQueryService;
import com.example.app.global.ApiResponse;
import com.example.app.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewQueryService reviewService;

    @GetMapping("/search")
    public ApiResponse<List<ReviewResDTO.ReviewInfo>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                ReviewConverter.toReviewInfoList(reviewService.searchReview(query, type))
        );
    }
}
