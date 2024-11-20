package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.API4_MemberMissionService;
import umc.study.web.dto.API4_MemberMissionRequestDTO;
import umc.study.web.dto.API4_MemberMissionResponseDTO;

@RestController
@RequestMapping("/api4/missions")
@RequiredArgsConstructor
public class API4_MemberMissionController {

    private final API4_MemberMissionService memberMissionService;

    @PostMapping("/challenge")
    public ResponseEntity<API4_MemberMissionResponseDTO> addMemberMission(@RequestBody API4_MemberMissionRequestDTO request) {
        API4_MemberMissionResponseDTO response = memberMissionService.addMemberMission(request);
        return ResponseEntity.ok(response);
    }
}
