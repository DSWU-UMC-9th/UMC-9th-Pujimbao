package com.example.app.domain.test.exception;

import com.example.app.global.apiPayload.code.BaseErrorCode;
import com.example.app.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
