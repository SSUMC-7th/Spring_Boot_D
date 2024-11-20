package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API3_MissionRequestDTO {

    @NotBlank
    private String title;

    private String description;

    private Integer reward;
}
