package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

   private final MemberRepository memberRepository;
   private final MissionRepository missionRepository;
   private final ReviewRepository reviewRepository;


    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<Review> myReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page,10));

        return myReviewPage;
    }

    @Override
    public Page<Mission> getMyMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<Mission> myMissionPage = missionRepository.findAllById(member, PageRequest.of(page, 10));
        return myMissionPage;
    }

}
