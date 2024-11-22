package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

public class ReviewConverter {
    public static ReviewResponseDTO.ReviewResultDTO toReivewResultDTO(Review review) {
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .memberId(review.getId())
                .nickname(review.getNickname())
                .description(review.getBody())
                .rating(review.getScore())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDTO request) {
        return Review.builder()
                .nickname(request.getNickname())
                .body(request.getDescription())
                .score(request.getRating())
                .id(request.getMemberId())
                .build();
    }
}
