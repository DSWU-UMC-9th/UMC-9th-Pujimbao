package com.example.app.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MissionResDTO {

    // 미션 목록의 개별 아이템
    @Builder
    public record MissionPreviewDTO(
            Long missionId,
            String condition,
            Integer point,
            LocalDate deadline
    ) {}

    // 페이징 응답 DTO
    @Builder
    public record MissionPreviewPageDTO(
            Integer currentPage,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast,
            List<MissionPreviewDTO> missionList
    ) {}
}
