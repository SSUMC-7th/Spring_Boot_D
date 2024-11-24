package umc.study.service;

import org.springframework.data.domain.Page;
import umc.study.web.dto.M9_API1_ReviewResponseDTO;

public interface M9_API1_ReviewService {
    Page<M9_API1_ReviewResponseDTO> getReviewList(Long storeId, Integer page);
}
