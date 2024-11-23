package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class joinDTO {
        Long memberId;

        Long missionId;

        Long StoreId;

        LocalDateTime startTime;
    }
}
