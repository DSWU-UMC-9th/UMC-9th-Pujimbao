package com.example.app.domain.review.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class ReviewReqDTO {
    private float rating;
    private String content;
    private List<String> images;
}
