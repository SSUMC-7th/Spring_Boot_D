package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    public final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Mission> getMyOngoingMissionList(Integer memberId, Integer page, String status) {
        Member member = memberRepository.findById(memberId).get();

        Page<Mission> MissionPage = memberRepository.findAllById(member, PageRequest.of(page,10));
        return MissionPage;
    }

    @Override
    public Page<Review> getMyReviewList(Integer memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<Review> myReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page,10));

        return myReviewPage;
    }

}