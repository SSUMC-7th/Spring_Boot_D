package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.API2_ReviewRepository;
import umc.study.repository.StoreRepository.API1_StoreRepository;
import umc.study.web.dto.API2_ReviewRequestDTO;
import umc.study.web.dto.API2_ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class API2_ReviewService {

    private final API2_ReviewRepository reviewRepository;
    private final API1_StoreRepository storeRepository;

    @Transactional
    public API2_ReviewResponseDTO addReview(Long storeId, API2_ReviewRequestDTO request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Review review = Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .score(request.getScore())
                .store(store)
                .build();

        Review savedReview = reviewRepository.save(review);

        return new API2_ReviewResponseDTO(
                savedReview.getId(),
                savedReview.getTitle(),
                savedReview.getContent(),
                savedReview.getScore(),
                savedReview.getStore().getId()
        );
    }
}
