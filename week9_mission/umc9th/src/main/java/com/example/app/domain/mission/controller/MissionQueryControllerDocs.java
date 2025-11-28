package com.example.app.domain.mission.controller;

import com.example.app.domain.mission.dto.MissionResDTO;
import com.example.app.global.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

public interface MissionQueryControllerDocs {

    @Operation(
            summary = "특정 가게의 미션 목록 조회 (페이징)",
            description = """
                    storeId 기준으로 해당 가게에 등록된 미션 목록을 페이징하여 조회합니다.
                    page는 반드시 1 이상의 값만 허용되며,
                    @ValidPage를 통해 잘못된 page 입력 시 예외가 발생합니다.
                    """
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "미션 조회 성공",
            content = @Content(schema = @Schema(implementation = MissionResDTO.MissionPreviewPageDTO.class))
    )
    ApiResponse<MissionResDTO.MissionPreviewPageDTO> getStoreMissions(Long storeId, Integer page);
}
