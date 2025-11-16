package com.example.app.domain.test.converter;

import com.example.app.domain.test.dto.res.TestResDTO;

public class TestConverter {

    // 객체 -> DTO
    public static TestResDTO.Testing toTestingDTO(
            String testing
    ) {
        return TestResDTO.Testing.builder()
                .testString(testing)
                .build();
    }

    public static TestResDTO.Exception toExceptionDTO(
            String testing
    ) {
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }
}
