package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.JoinResultDTO toMissionResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .storeId(mission.getStore().getId())
                .storeName(mission.getStore().getName())
                .startTime(LocalDateTime.now())
                .missionChallengeId(mission.getId())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.joinDTO request) {
        return Mission.builder()
                .id(request.getMissionId())
                .build();
    }
}
