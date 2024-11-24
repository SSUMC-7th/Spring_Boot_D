package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.repository.M9_API4_MissionRepository;
import umc.study.web.dto.M9_API4_MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class M9_API4_MissionServiceImpl implements M9_API4_MissionService {

    private final M9_API4_MissionRepository missionRepository;

    @Override
    @Transactional
    public void completeMission(Long missionId, Long userId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        mission.setStatus("COMPLETED");
        mission.setUserId(userId);
        missionRepository.save(mission);
    }

    @Override
    @Transactional(readOnly = true)
    public List<M9_API4_MissionResponseDTO> getCompletedMissions(Long userId) {
        List<Mission> completedMissions = missionRepository.findCompletedMissionsByUserId(userId);

        return completedMissions.stream()
                .map(mission -> new M9_API4_MissionResponseDTO(mission.getId(), mission.getTitle(), mission.getDescription(), mission.getReward(), mission.getStatus()))
                .collect(Collectors.toList());
    }
}
