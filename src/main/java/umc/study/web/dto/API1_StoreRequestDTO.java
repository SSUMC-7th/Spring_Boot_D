package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API1_StoreRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String address;
}
