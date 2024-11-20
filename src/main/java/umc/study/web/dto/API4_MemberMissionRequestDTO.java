package umc.study.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API4_MemberMissionRequestDTO {
    private Long memberId; // 도전할 회원의 ID
    private Long missionId; // 도전할 미션의 ID
}
