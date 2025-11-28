package com.example.app.domain.review.exception;

import com.example.app.global.apiPayload.code.BaseErrorCode;
import com.example.app.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {

    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
