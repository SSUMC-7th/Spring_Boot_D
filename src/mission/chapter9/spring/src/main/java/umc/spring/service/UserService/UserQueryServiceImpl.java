package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.MissionAssigned;
import umc.spring.repository.MissionAssignedRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final MissionAssignedRepository missionAssignedRepository;

    @Override
    public Page<Review> getReviewList(Long userId, Integer page) {

        User user = userRepository.findById(userId).get();

        Page<Review> userPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return userPage;
    }

    @Override
    public Page<MissionAssigned> getMissionAssignedList(Long userId, Integer page) {

        User user = userRepository.findById(userId).get();

        Page<MissionAssigned> userPage = missionAssignedRepository.findAllByUser(user, PageRequest.of(page, 10));
        return userPage;
    }

    @Override
    public Page<MissionAssigned> getCompletedMissionAssignedList(Long userId, Integer page) {

        User user = userRepository.findById(userId).get();

        Page<MissionAssigned> userPage = missionAssignedRepository.findTrueByUser(user, PageRequest.of(page, 10));
        return userPage;
    }

}
