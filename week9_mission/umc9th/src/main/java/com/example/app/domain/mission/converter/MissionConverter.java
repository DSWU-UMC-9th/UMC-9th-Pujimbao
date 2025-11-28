package com.example.app.domain.mission.converter;

import com.example.app.domain.mission.dto.MissionResDTO;
import com.example.app.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public MissionResDTO.MissionPreviewDTO toMissionPreview(Mission mission) {
        return MissionResDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .condition(mission.getCondition())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .build();
    }

    public MissionResDTO.MissionPreviewPageDTO toMissionPage(Page<Mission> page) {
        return MissionResDTO.MissionPreviewPageDTO.builder()
                .currentPage(page.getNumber() + 1)
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .missionList(page.getContent().stream()
                        .map(this::toMissionPreview)
                        .toList())
                .build();
    }
}
