package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.OTHER;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .spec_address(request.getSpecAddress())
                .gender(gender)
                .age(request.getAge())
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MyOngoingMissionPreviewDTO myOngoingMissionPreviewDTO(Mission mission) {
        return null;
    }

    public static MemberResponseDTO.MyOngoingMissionPreviewListDTO myOngoingMissionPreviewListDTO(List<Mission> missionList) {
        return null;
    }
}
