package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.myReviewPreViewDTO myReviewPreViewDTO(Review review){
        return MemberResponseDTO.myReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static MemberResponseDTO.myReviewPreViewListDTO myReviewPreViewListDTO(Page<Review> myReviewList){
        List<MemberResponseDTO.myReviewPreViewDTO> myReviewPreViewDTOList = myReviewList.stream()
                .map(MemberConverter::myReviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.myReviewPreViewListDTO.builder()
                .isLast(myReviewList.isLast())
                .isFirst(myReviewList.isFirst())
                .totalPage(myReviewList.getTotalPages())
                .totalElements(myReviewList.getTotalElements())
                .listSize(myReviewPreViewDTOList.size())
                .myReviewList(myReviewPreViewDTOList)
                .build();
    }

    public static MemberResponseDTO.myMissionPreViewDTO myMissionPreViewDTO(Mission mission){

        return MemberResponseDTO.myMissionPreViewDTO.builder()
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .deadline(mission.getDeadline())
                .build();
    }
    public static MemberResponseDTO.myMissionPreViewListDTO myMissionPreViewListDTO(Page<Mission> missionList){
        List<StoreResponseDTO.StoreMissionPreViewDTO> myMissionPreViewDTOList = missionList.stream()
                .map(StoreConverter::storeMissionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.myMissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(myMissionPreViewDTOList.size())
                .missionList(myMissionPreViewDTOList)
                .build();
    }
}
