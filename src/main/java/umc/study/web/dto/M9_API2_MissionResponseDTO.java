package umc.study.web.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class M9_API2_MissionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Integer reward;
    private LocalDate deadline;
}
