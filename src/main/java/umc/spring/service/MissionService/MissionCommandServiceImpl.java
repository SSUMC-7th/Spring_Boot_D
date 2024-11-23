package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;


@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.joinDTO request){

        Mission newMission = MissionConverter.toMission(request);
        return missionRepository.save(newMission);
    }
}

