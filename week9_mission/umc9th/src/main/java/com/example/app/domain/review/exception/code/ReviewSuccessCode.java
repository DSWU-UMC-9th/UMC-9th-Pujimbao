package com.example.app.domain.review.exception.code;

import com.example.app.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    CREATE_REVIEW_SUCCESS(HttpStatus.CREATED,
            "REVIEW201_1",
            "리뷰가 성공적으로 등록되었습니다."),

    READ_REVIEW_SUCCESS(HttpStatus.OK,
            "Review200_1",
            "리뷰 조회가 완료되었습니다."),

    UPDATE_REVIEW_SUCCESS(HttpStatus.OK,
            "REVIEW200_2",
            "리뷰가 성공적으로 수정되었습니다."),

    DELETE_REVIEW_SUCCESS(HttpStatus.OK,
            "REVIEW200_3",
            "리뷰가 성공적으로 삭제되었습니다.");


    private final HttpStatus status;
    private final String code;
    private final String message;
}
