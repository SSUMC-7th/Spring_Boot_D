package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReview(ReviewRequestDTO.JoinDto request,Long storeId);

}
