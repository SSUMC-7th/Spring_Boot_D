package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;

public interface MemberQueryService {
    Page<Mission> getMyOngoingMissionList(Integer memberId, Integer page, String status);

    Page<Review> getMyReviewList(Integer memberId, Integer page);
}
