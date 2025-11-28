package com.example.app.global.apiPayload.exception;

import com.example.app.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;

@Getter
public class PageValidationException extends RuntimeException {

    private final BaseErrorCode errorCode;

    public PageValidationException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
