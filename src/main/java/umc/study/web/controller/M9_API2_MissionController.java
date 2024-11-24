package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.service.M9_API2_MissionService;
import umc.study.validation.annotation.M9_API2_CheckPage;
import umc.study.web.dto.M9_API2_MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class M9_API2_MissionController {

    private final M9_API2_MissionService missionService;

    @GetMapping("/store")
    @Operation(summary = "특정 가게의 미션 목록 조회", description = "특정 가게에 작성된 미션을 페이징 처리하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게를 찾을 수 없음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 에러")
    })
    public ResponseEntity<Page<M9_API2_MissionResponseDTO>> getStoreMissions(
            @RequestParam(name = "storeId") Long storeId,
            @RequestParam(name = "page", defaultValue = "0") @M9_API2_CheckPage Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size) {

        Page<M9_API2_MissionResponseDTO> missions = missionService.getMissionList(storeId, PageRequest.of(page, size));

        return ResponseEntity.ok(missions);
    }
}