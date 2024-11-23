package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;

import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.joinDTO request) {
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }
}
