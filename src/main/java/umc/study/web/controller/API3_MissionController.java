package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.API3_MissionService;
import umc.study.web.dto.API3_MissionRequestDTO;
import umc.study.web.dto.API3_MissionResponseDTO;

@RestController
@RequestMapping("/api3/stores")
@RequiredArgsConstructor
public class API3_MissionController {

    private final API3_MissionService missionService;

    @PostMapping("/{storeId}/missions")
    public ResponseEntity<API3_MissionResponseDTO> addMission(
            @PathVariable Long storeId,
            @RequestBody API3_MissionRequestDTO request) {
        API3_MissionResponseDTO response = missionService.addMission(storeId, request);
        return ResponseEntity.ok(response);
    }
}
