package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    @Override
    public Page<Mission> getMyOngoingMissionList(Integer memberId, Integer page, Enum status) {
        return null;
    }
}