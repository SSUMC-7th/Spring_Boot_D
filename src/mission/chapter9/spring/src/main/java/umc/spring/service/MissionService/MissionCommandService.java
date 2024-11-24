package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;

public interface MissionCommandService {

    Mission joinMission(MissionRequestDTO.JoinDto request, Long restaurantId);

}
