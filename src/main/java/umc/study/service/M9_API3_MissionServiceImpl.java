package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.study.repository.M9_API3_MissionRepository;
import umc.study.web.dto.M9_API3_MissionResponseDTO;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class M9_API3_MissionServiceImpl implements M9_API3_MissionService {

    private final M9_API3_MissionRepository missionRepository;
    @Override
    public Page<M9_API3_MissionResponseDTO> getMyProgressMissions(Long userId, Pageable pageable) {
        return missionRepository.findAllByMemberMissionList(userId, LocalDate.now(), pageable)
                .map(mission -> M9_API3_MissionResponseDTO.builder()
                        .id(mission.getId())
                        .title(mission.getTitle())
                        .description(mission.getDescription())
                        .reward(mission.getReward())
                        .deadline(mission.getDeadline().atStartOfDay())
                        .build());
    }

}
