package umc.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.UserHandler;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.ReviewResponseDTO;

import java.util.List;

@Component
public class ReviewConverter {

    private final UserRepository userRepository;

    @Autowired
    public ReviewConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public Review toReview(ReviewRequestDTO.JoinDto request, Restaurant restaurant) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .restaurant(restaurant)
                .user(user)
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return null;
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(List<Review> reviewList) {
        return null;
    }

}
