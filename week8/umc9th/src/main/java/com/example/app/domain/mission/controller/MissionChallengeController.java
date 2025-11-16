package com.example.app.domain.mission.controller;

import com.example.app.domain.mission.service.MissionChallengeService;
import com.example.app.global.ApiResponse;
import com.example.app.global.apiPayload.code.BaseSuccessCode;
import com.example.app.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionChallengeController {

    private final MissionChallengeService missionChallengeService;
    private final Long FIXED_USER_ID = 1L;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<Void> challengeMission(@PathVariable Long missionId) {

        missionChallengeService.challenge(FIXED_USER_ID, missionId);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}
