package umc.spring.converter;

import org.springframework.stereotype.Component;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Region;
import umc.spring.domain.enums.RestaurantCategory;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

@Component
public class RestaurantConverter {

    public static RestaurantResponseDTO.JoinResultDTO toJoinResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.JoinResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.JoinDto request, Region region) {
        RestaurantCategory restaurantCategory = null;

        switch (request.getCategory()) {
            case 1:
                restaurantCategory = RestaurantCategory.KOREAN;
                break;
            case 2:
                restaurantCategory = RestaurantCategory.CHINESE;
                break;
            case 3:
                restaurantCategory = RestaurantCategory.JAPANESE;
                break;
            case 4:
                restaurantCategory = RestaurantCategory.ITALIAN;
                break;
            case 5:
                restaurantCategory = RestaurantCategory.VIETNAMESE;
                break;
        }

        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .rating(request.getRating())
                .category(restaurantCategory)
                .region(region)
                .build();
    }

}
