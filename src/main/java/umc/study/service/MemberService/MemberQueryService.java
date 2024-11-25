package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;

public interface MemberQueryService {
    Page<Mission> getMyOngoingMissionList(Integer memberId, Integer page, Enum status);

}
