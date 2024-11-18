package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API2_ReviewRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Float score;
}