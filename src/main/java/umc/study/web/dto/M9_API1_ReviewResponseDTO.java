package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class M9_API1_ReviewResponseDTO {
    private Long id;
    private String title;
    private String body;
    private Double score;
    private String storeName;
}
