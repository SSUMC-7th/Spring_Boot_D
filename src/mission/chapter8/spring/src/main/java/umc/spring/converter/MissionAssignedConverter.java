package umc.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.MissionAssigned;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.MissionAssignedRequestDTO;
import umc.spring.web.dto.MissionAssignedResponseDTO;

@Component
public class MissionAssignedConverter {

    private final UserRepository userRepository;

    @Autowired
    public MissionAssignedConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static MissionAssignedResponseDTO.JoinResultDTO toJoinResultDTO(MissionAssigned missionAssigned) {
        return MissionAssignedResponseDTO.JoinResultDTO.builder()
                .missionAssignedId(missionAssigned.getId())
                .createdAt(missionAssigned.getCreatedAt())
                .build();
    }

    public MissionAssigned toMissionAssigned(MissionAssignedRequestDTO.JoinDto request, Mission mission) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return MissionAssigned.builder()
                .isCompleted(false)
                .mission(mission)
                .user(user)
                .build();
    }

}
