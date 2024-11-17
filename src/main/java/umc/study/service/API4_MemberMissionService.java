package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.API3_MissionRepository;
import umc.study.repository.API4_MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.API4_MemberMissionRequestDTO;
import umc.study.web.dto.API4_MemberMissionResponseDTO;

@Service
@RequiredArgsConstructor
public class API4_MemberMissionService {

    private final MemberRepository memberRepository;
    private final API3_MissionRepository missionRepository;
    private final API4_MemberMissionRepository memberMissionRepository;

    @Transactional
    public API4_MemberMissionResponseDTO addMemberMission(API4_MemberMissionRequestDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING) // 기본 상태는 CHALLENGING
                .build();

        MemberMission savedMemberMission = memberMissionRepository.save(memberMission);

        return new API4_MemberMissionResponseDTO(
                savedMemberMission.getId(),
                savedMemberMission.getMember().getId(),
                savedMemberMission.getMission().getId(),
                savedMemberMission.getStatus().name()
        );
    }
}
