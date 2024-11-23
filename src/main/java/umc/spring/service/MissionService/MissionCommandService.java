package umc.spring.service.MissionService;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission joinMission(MissionRequestDTO.joinDTO request);
}
