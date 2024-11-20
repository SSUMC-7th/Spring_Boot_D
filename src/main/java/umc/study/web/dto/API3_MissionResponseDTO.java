package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class API3_MissionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Integer reward;
    private Long storeId;
}