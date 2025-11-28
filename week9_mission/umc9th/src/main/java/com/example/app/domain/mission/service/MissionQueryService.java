package com.example.app.domain.mission.service;

import com.example.app.domain.mission.converter.MissionConverter;
import com.example.app.domain.mission.dto.MissionResDTO;
import com.example.app.domain.mission.entity.Mission;
import com.example.app.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryService {

    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;

    public MissionResDTO.MissionPreviewPageDTO getMissions(Long storeId, Integer page) {

        PageRequest pageable = PageRequest.of(page, 10);

        Page<Mission> result = missionRepository.findByStore_Id(storeId, pageable);

        return missionConverter.toMissionPage(result);
    }
}
