package umc.study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.web.dto.M9_API3_MissionResponseDTO;

public interface M9_API3_MissionService {
    Page<M9_API3_MissionResponseDTO> getMyProgressMissions(Long userId, Pageable pageable);
}
