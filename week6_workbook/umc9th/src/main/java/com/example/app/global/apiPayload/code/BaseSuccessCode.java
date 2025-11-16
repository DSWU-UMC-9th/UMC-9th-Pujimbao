package com.example.app.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public interface BaseSuccessCode {

    HttpStatus getStatus();   // 성공 시 HTTP 상태 코드
    String getCode();         // 커스텀 성공 코드
    String getMessage();      // 성공 메시지
}
