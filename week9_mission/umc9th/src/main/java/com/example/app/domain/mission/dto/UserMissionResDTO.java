package com.example.app.domain.mission.dto;

import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

public class UserMissionResDTO {

    @Builder
    public record UserMissionDTO(
            Long userMissionId,
            String condition,
            Integer point,
            LocalDate deadline,
            String status
    ) {}

    @Builder
    public record UserMissionPageDTO(
            Integer currentPage,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast,
            List<UserMissionDTO> missionList
    ) {}
}
