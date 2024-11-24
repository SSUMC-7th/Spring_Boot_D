package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMissionAssigned;
import umc.spring.validation.annotation.ExistUser;

public class MissionAssignedRequestDTO {

    @Getter
    @ExistMissionAssigned
    public static class JoinDto {
        @ExistUser
        @NotNull
        Long userId;

        public Long getUserId() {
            return userId;
        }
    }

}
