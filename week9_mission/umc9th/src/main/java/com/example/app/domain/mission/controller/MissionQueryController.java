package com.example.app.domain.mission.controller;

import com.example.app.domain.mission.dto.MissionResDTO;
import com.example.app.domain.mission.service.MissionQueryService;
import com.example.app.global.ApiResponse;
import com.example.app.global.annotation.ValidPage;
import com.example.app.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionQueryController implements MissionQueryControllerDocs {

    private final MissionQueryService missionQueryService;

    @GetMapping("/store")
    public ApiResponse<MissionResDTO.MissionPreviewPageDTO> getStoreMissions(
            @RequestParam Long storeId,
            @ValidPage @RequestParam Integer page
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                missionQueryService.getMissions(storeId, page)
        );
    }
}
