package umc.study.service;

import java.util.List;
import umc.study.web.dto.M9_API4_MissionResponseDTO;

public interface M9_API4_MissionService {
    // 미션을 완료 처리하는 메서드
    void completeMission(Long missionId, Long userId);

    // 완료된 미션 목록을 조회하는 메서드
    List<M9_API4_MissionResponseDTO> getCompletedMissions(Long userId);
}
