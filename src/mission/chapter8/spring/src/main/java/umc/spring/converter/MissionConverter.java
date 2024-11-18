package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;


@Component
public class MissionConverter {

    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public Mission toMission(MissionRequestDTO.JoinDto request, Restaurant restaurant) {
        return Mission.builder()
                .content(request.getContent())
                .getPoint(request.getPoint())
                .restaurant(restaurant)
                .build();
    }

}
