package com.example.app.domain.review.controller;

import com.example.app.domain.review.dto.ReviewResDTO;
import com.example.app.global.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

public interface ReviewControllerDocs {

    @Operation(
            summary = "특정 가게의 리뷰 목록 조회 (페이징)",
            description = """
                    storeName 기준으로 해당 가게의 리뷰 목록을 페이징하여 조회합니다.
                    page는 반드시 1 이상의 값만 허용되며,
                    @ValidPage를 통해 잘못된 page 입력 시 예외가 발생합니다.
                    """
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "리뷰 조회 성공",
            content = @Content(schema = @Schema(implementation = ReviewResDTO.ReviewPreViewListDTO.class))
    )
    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(String storeName, Integer page);


    @Operation(
            summary = "내가 작성한 리뷰 목록 조회 (페이징)",
            description = """
                    memberId 기준으로 내가 작성한 리뷰 목록을 조회합니다.
                    page는 반드시 1 이상의 값만 허용됩니다.
                    @ValidPage를 통해 잘못된 page 입력 시 예외가 발생합니다.
                    """
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "내 리뷰 조회 성공",
            content = @Content(schema = @Schema(implementation = ReviewResDTO.ReviewPreViewListDTO.class))
    )
    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviews(Long memberId, Integer page);
}
