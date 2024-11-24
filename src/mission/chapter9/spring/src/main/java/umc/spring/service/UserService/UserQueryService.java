package umc.spring.service.UserService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MissionAssigned;

public interface UserQueryService {

    Page<Review> getReviewList(Long userId, Integer page);

    Page<MissionAssigned> getMissionAssignedList(Long userId, Integer page);

    Page<MissionAssigned> getCompletedMissionAssignedList(Long userId, Integer page);

}
