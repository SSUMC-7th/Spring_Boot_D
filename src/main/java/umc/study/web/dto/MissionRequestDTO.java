package umc.study.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {

    @Getter
    public static class MissionDTO {
        Long memberId;
        Long missionId;
        Long StoreId;
        LocalDateTime startTime;
    }
}
