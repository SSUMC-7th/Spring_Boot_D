package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class API4_MemberMissionResponseDTO {
    private Long id;
    private Long memberId;
    private Long missionId;
    private String status;
}
