package com.example.app.global.apiPayload.handler;

import com.example.app.global.ApiResponse;
import com.example.app.global.apiPayload.code.BaseErrorCode;
import com.example.app.global.apiPayload.code.GeneralErrorCode;
import com.example.app.global.apiPayload.exception.GeneralException;
import com.example.app.global.apiPayload.exception.PageValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionAdvice {

    // 애플리케이션에서 발생하는 커스텀 예외 처리
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<Void>> handleException(
            GeneralException ex
    ) {
        return ResponseEntity.status(ex.getCode().getStatus())
                .body(ApiResponse.onFailure(
                        ex.getCode(),
                        null
                ));
    }

    // 커스텀 page 유효성 검증 실패 처리 추가
    @ExceptionHandler(PageValidationException.class)
    public ResponseEntity<ApiResponse<Void>> handlePageValidation(PageValidationException ex) {
        return ResponseEntity
                .status(ex.getErrorCode().getStatus())
                .body(ApiResponse.onFailure(
                        ex.getErrorCode(),
                        null
                ));
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(
            Exception ex
    ) {
        BaseErrorCode code = GeneralErrorCode.Internal_SERVER_ERROR;
        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(
                        code,
                        ex.getMessage()
                ));
    }
}
