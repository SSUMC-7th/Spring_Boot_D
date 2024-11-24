package umc.spring.service.MissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    private final MissionConverter missionConverter;

    @Autowired
    public MissionCommandServiceImpl(MissionRepository missionRepository,
                                     RestaurantRepository restaurantRepository,
                                     MissionConverter missionConverter) {
        this.missionRepository = missionRepository;
        this.restaurantRepository = restaurantRepository;
        this.missionConverter = missionConverter;
    }

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDTO.JoinDto request, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Mission newMission = missionConverter.toMission(request, restaurant);
        return missionRepository.save(newMission);
    }

}
