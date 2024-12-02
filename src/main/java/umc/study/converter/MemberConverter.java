package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {

        Gender gender = null;
        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE; break;
            case 2:
                gender = Gender.FEMALE; break;
            case 3:
                gender = Gender.NONE; break;
        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress())
                .spec_address(request.getSpecAddress())
                .gender(gender)
//                .age(request.getAge())
                .memberPreferList(new ArrayList<>())
                .role(request.getRole())
                .build();
    }

    public static MemberResponseDTO.MyOngoingMissionPreviewDTO myOngoingMissionPreviewDTO(Mission mission) {
        return MemberResponseDTO.MyOngoingMissionPreviewDTO.builder()
                .storeName(mission.getStore().getName())
                .missionId(mission.getId())
                .description(mission.getMissionSpec())
                .build();
    }

    public static MemberResponseDTO.MyOngoingMissionPreviewListDTO myOngoingMissionPreviewListDTO(Page<Mission> missionList) {

        List<MemberResponseDTO.MyOngoingMissionPreviewDTO> myOngoingMissionPreviewDTOList = missionList.stream()
                .map(MemberConverter::myOngoingMissionPreviewDTO).collect(Collectors.toList());
        return MemberResponseDTO.MyOngoingMissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .listSize(missionList.getSize())
                .myOngoingMissionList(myOngoingMissionPreviewDTOList)
                .build();
    }

    public static MemberResponseDTO.MyReviewPreviewDTO myReviewPreviewDTO(Review myReview) {
        return MemberResponseDTO.MyReviewPreviewDTO.builder()
                .ownerNickname(myReview.getNickname())
                .score(myReview.getScore())
                .createdAt(myReview.getCreatedAt().toLocalDate())
                .body(myReview.getBody())
                .build();
    }

    public static MemberResponseDTO.MyReviewPreviewListDTO myReviewPreviewListDTO(Page<Review> myReviewList) {

        List<MemberResponseDTO.MyReviewPreviewDTO> myReviewPreviewDTOList = myReviewList.stream()
                .map(MemberConverter::myReviewPreviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MyReviewPreviewListDTO.builder()
                .isLast(myReviewList.isEmpty())
                .isFirst(myReviewList.isEmpty())
                .totalPage(myReviewList.getTotalPages())
                .totalElements(myReviewList.getTotalElements())
                .listSize(myReviewList.getSize())
                .myreviewPreviewList(myReviewPreviewDTOList)
                .build();
    }
}
