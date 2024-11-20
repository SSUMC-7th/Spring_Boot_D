package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.API3_MissionRepository;
import umc.study.repository.StoreRepository.API1_StoreRepository;
import umc.study.web.dto.API3_MissionRequestDTO;
import umc.study.web.dto.API3_MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class API3_MissionService {

    private final API1_StoreRepository storeRepository;
    private final API3_MissionRepository missionRepository;

    @Transactional
    public API3_MissionResponseDTO addMission(Long storeId, API3_MissionRequestDTO request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Mission mission = Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .reward(request.getReward())
                .store(store)
                .build();

        Mission savedMission = missionRepository.save(mission);

        return new API3_MissionResponseDTO(
                savedMission.getId(),
                savedMission.getTitle(),
                savedMission.getDescription(),
                savedMission.getReward(),
                savedMission.getStore().getId()
        );
    }
}

