package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class JoinDto {

        @Size(min = 5, max = 50)
        private String content;
        @NotNull
        private Integer point;

    }

}
