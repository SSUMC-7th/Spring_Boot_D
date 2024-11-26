package umc.study.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.M9_API1_ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.M9_API1_ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class M9_API1_ReviewServiceImpl implements M9_API1_ReviewService {

    private final StoreRepository storeRepository;
    private final M9_API1_ReviewRepository reviewRepository;

    @Override
    public Page<M9_API1_ReviewResponseDTO> getReviewList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("Store with ID " + storeId + " not found"));


        Page<Review> reviews = reviewRepository.findAllByStore(
                store,
                PageRequest.of(page, 10)
        );

        return reviews.map(review -> new M9_API1_ReviewResponseDTO(
                review.getId(),
                review.getTitle(),
                review.getBody(),
                review.getScore().doubleValue(),
                review.getStore().getName()
        ));
    }
}
