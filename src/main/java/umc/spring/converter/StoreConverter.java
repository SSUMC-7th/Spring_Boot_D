package umc.spring.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreConverter {

    @GetMapping("{storeID}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewPreViewDTO> getReviewList(@PathVariable(name="storeId") Long storeId){
        return null;
    }
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
            return StoreResponseDTO.ReviewPreViewDTO.builder()
                    .ownerNickname(review.getMember().getName())
                    .score(review.getScore())
                    .createdAt(review.getCreatedAt().toLocalDate())
                    .body(review.getBody())
                    .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
            List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                    .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

            return StoreResponseDTO.ReviewPreViewListDTO.builder()
                    .isLast(reviewList.isLast())
                    .isFirst(reviewList.isFirst())
                    .totalPage(reviewList.getTotalPages())
                    .totalElements(reviewList.getTotalElements())
                    .listSize(reviewPreViewDTOList.size())
                    .reviewList(reviewPreViewDTOList)
                    .build();
    }
}
