package com.example.app.domain.mission.controller;

import com.example.app.domain.mission.dto.UserMissionResDTO;
import com.example.app.domain.mission.service.UserMissionQueryService;
import com.example.app.global.ApiResponse;
import com.example.app.global.annotation.ValidPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-missions")
public class UserMissionQueryController implements UserMissionQueryControllerDocs{

    private final UserMissionQueryService service;

    @GetMapping("/ongoing")
    public ApiResponse<UserMissionResDTO.UserMissionPageDTO> getMyOngoingMissions(
            @RequestParam Long memberId,
            @ValidPage @RequestParam Integer page
    ) {
        return ApiResponse.onSuccess(
                com.example.app.global.apiPayload.code.GeneralSuccessCode.OK, // 성공 코드
                service.getMyOngoingMissions(memberId, page) // 데이터
        );
    }
}
