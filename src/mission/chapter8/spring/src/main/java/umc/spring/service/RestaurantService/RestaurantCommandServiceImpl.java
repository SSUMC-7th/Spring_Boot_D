package umc.spring.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.web.dto.RestaurantRequestDTO;

@Service
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Autowired
    public RestaurantCommandServiceImpl(RestaurantRepository restaurantRepository, RegionRepository regionRepository) {
        this.restaurantRepository = restaurantRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    @Transactional
    public Restaurant joinRestaurant(RestaurantRequestDTO.JoinDto request, Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Restaurant restaurant = RestaurantConverter.toRestaurant(request, region);

        return restaurantRepository.save(restaurant);
    }

}
