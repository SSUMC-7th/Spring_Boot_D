package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class API2_ReviewResponseDTO {
    private Long id;
    private String title;
    private String content;
    private Float score;
    private Long storeId;
}