package com.example.app.domain.mission.service;

import com.example.app.domain.mission.entity.MissionStatus;
import com.example.app.domain.mission.entity.UserMission;
import com.example.app.domain.mission.repository.UserMissionRepository;
import com.example.app.domain.mission.dto.UserMissionResDTO;
import com.example.app.domain.mission.converter.UserMissionConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;
    private final UserMissionConverter userMissionConverter;

    public UserMissionResDTO.UserMissionPageDTO getMyOngoingMissions(Long memberId, Integer page) {

        PageRequest pageable = PageRequest.of(page, 10);

        Page<UserMission> result =
                userMissionRepository.findByMember_IdAndStatus(memberId, MissionStatus.ONGOING, pageable);

        return userMissionConverter.toUserMissionPage(result);
    }
}
