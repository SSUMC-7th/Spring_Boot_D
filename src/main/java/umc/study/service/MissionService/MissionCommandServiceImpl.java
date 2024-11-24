package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.MissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        return missionRepository.save(newMission);
    }
}
