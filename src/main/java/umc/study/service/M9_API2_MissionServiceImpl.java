package umc.study.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.M9_API2_MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.M9_API2_MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class M9_API2_MissionServiceImpl implements M9_API2_MissionService {

    private final StoreRepository storeRepository;
    private final M9_API2_MissionRepository missionRepository;

    @Override
    public Page<M9_API2_MissionResponseDTO> getMissionList(Long storeId, Pageable pageable) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("Store with ID " + storeId + " not found"));

        Page<Mission> missions = missionRepository.findAllByStore(store, pageable);

        return missions.map(mission -> M9_API2_MissionResponseDTO.builder()
                .id(mission.getId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build());
    }
}
