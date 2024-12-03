package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    private final MissionRepository missionRepository;

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findRestaurantsByNameAndRating(String name, Float rating) {
        List<Restaurant> filteredRestaurants = restaurantRepository.dynamicQueryWithBooleanBuilder(name, rating);

        filteredRestaurants.forEach(restaurant -> System.out.println("Restaurant: " + restaurant));

        return filteredRestaurants;
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Review> restaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return restaurantPage;
    }

    @Override
    public Page<Mission> getMissionList(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Mission> restaurantPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return restaurantPage;
    }

}