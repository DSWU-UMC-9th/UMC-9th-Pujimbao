package com.example.app.global.apiPayload.exception;

import com.example.app.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private final BaseErrorCode code;
}

// 프a로젝트 Exception