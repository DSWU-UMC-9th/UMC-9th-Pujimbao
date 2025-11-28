package com.example.app.domain.mission.controller;

import com.example.app.domain.mission.dto.UserMissionResDTO;
import com.example.app.global.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

public interface UserMissionQueryControllerDocs {

    @Operation(
            summary = "내가 진행 중인 미션 목록 조회 (페이징)",
            description = """
                    memberId 기준으로 진행 상태(MissionStatus.ONGOING)인 미션 목록을 조회합니다.
                    page는 반드시 1 이상의 값만 허용됩니다.
                    @ValidPage가 자동 검증을 수행하며, 잘못된 page 입력 시 예외가 발생합니다.
                    """
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "진행 중인 미션 조회 성공",
            content = @Content(schema = @Schema(implementation = UserMissionResDTO.UserMissionPageDTO.class))
    )
    ApiResponse<UserMissionResDTO.UserMissionPageDTO> getMyOngoingMissions(Long memberId, Integer page);
}
