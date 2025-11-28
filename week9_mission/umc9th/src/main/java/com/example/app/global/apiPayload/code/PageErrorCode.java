package com.example.app.global.apiPayload.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PageErrorCode implements BaseErrorCode {

    INVALID_PAGE(HttpStatus.BAD_REQUEST,
            "PAGE400_1",
            "page 값은 1 이상의 정수여야 합니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
