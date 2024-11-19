package umc.spring.service.MissionAssignedService;

import umc.spring.domain.Review;
import umc.spring.domain.mapping.MissionAssigned;
import umc.spring.web.dto.MissionAssignedRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;

public interface MissionAssignedCommandService {

    MissionAssigned joinMissionAssigned(MissionAssignedRequestDTO.JoinDto request, Long missionId, Long userId);

}
