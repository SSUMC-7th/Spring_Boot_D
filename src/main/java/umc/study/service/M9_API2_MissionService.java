package umc.study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.web.dto.M9_API2_MissionResponseDTO;

public interface M9_API2_MissionService {
    Page<M9_API2_MissionResponseDTO> getMissionList(Long storeId, Pageable pageable);
}