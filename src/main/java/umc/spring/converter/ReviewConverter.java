package umc.spring.converter;
import org.springframework.stereotype.Component;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import java.time.LocalDateTime;

@Component
public class ReviewConverter {
    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review){
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinDto request){

        return Review.builder()
                .score(request.getRating())
                .store(request.getStoreId())
                .title(request.getTitle())
                .body(request.getContent())
                .build();
    }
}
