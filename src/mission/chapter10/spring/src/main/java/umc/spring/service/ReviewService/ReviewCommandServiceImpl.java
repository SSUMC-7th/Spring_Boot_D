package umc.spring.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewConverter reviewConverter;

    @Autowired
    public ReviewCommandServiceImpl(ReviewRepository reviewRepository,
                                    RestaurantRepository restaurantRepository,
                                    ReviewConverter reviewConverter) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.reviewConverter = reviewConverter;
    }

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinDto request, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Review newReview = reviewConverter.toReview(request, restaurant);

        return reviewRepository.save(newReview);
    }

}
