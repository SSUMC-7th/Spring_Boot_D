package umc.spring.service.RestaurantService;

import umc.spring.domain.Restaurant;
import umc.spring.domain.User;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

public interface RestaurantCommandService {

    Restaurant joinRestaurant(RestaurantRequestDTO.JoinDto request, Long regionId);

}
