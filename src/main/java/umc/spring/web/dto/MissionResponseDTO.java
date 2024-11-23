package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        Long missionChallengeId;
        Long missionId;
        Long storeId;
        String storeName;
        LocalDateTime startTime;
        List<String> memberMissionList;
        LocalDateTime createdAt;
    }
}
