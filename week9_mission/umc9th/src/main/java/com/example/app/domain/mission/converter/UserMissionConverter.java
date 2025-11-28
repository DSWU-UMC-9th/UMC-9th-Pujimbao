package com.example.app.domain.mission.converter;

import com.example.app.domain.mission.dto.UserMissionResDTO;
import com.example.app.domain.mission.entity.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserMissionConverter {

    public UserMissionResDTO.UserMissionDTO toDTO(UserMission um) {
        return UserMissionResDTO.UserMissionDTO.builder()
                .userMissionId(um.getId())
                .condition(um.getMission().getCondition())
                .point(um.getMission().getPoint())
                .deadline(um.getMission().getDeadline())
                .status(um.getStatus().name())
                .build();
    }

    public UserMissionResDTO.UserMissionPageDTO toUserMissionPage(Page<UserMission> page) {
        return UserMissionResDTO.UserMissionPageDTO.builder()
                .currentPage(page.getNumber() + 1)
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .missionList(page.getContent().stream()
                        .map(this::toDTO)
                        .toList())
                .build();
    }
}
