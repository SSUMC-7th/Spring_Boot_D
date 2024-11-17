package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.API1_RegionRepository;
import umc.study.repository.StoreRepository.API1_StoreRepository;
import umc.study.web.dto.API1_StoreRequestDTO;
import umc.study.web.dto.API1_StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class API1_StoreService {

    private final API1_StoreRepository storeRepository;
    private final API1_RegionRepository regionRepository;

    @Transactional
    public API1_StoreResponseDTO addStore(Long regionId, API1_StoreRequestDTO request) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));

        System.out.println("Region: " + region); // 디버깅

        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .score(0.0f)
                .build();

        System.out.println("Store: " + store); // 디버깅

        Store savedStore = storeRepository.save(store);

        return new API1_StoreResponseDTO(savedStore.getId(), savedStore.getName(), savedStore.getAddress());
    }
}

