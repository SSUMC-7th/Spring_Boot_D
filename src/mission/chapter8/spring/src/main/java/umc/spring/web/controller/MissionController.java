package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionAssignedConverter;
import umc.spring.domain.mapping.MissionAssigned;
import umc.spring.service.MissionAssignedService.MissionAssignedCommandService;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.web.dto.MissionAssignedRequestDTO;
import umc.spring.web.dto.MissionAssignedResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
@Validated
public class MissionController {

    private final MissionAssignedCommandService missionAssignedCommandService;

    @PostMapping("/{missionId}")
    public ApiResponse<MissionAssignedResponseDTO.JoinResultDTO> join(@RequestBody @Valid MissionAssignedRequestDTO.JoinDto request, @PathVariable @ExistMission Long missionId) {
        MissionAssigned missionAssigned = missionAssignedCommandService.joinMissionAssigned(request, missionId, request.getUserId());
        return ApiResponse.onSuccess(MissionAssignedConverter.toJoinResultDTO(missionAssigned));
    }

}