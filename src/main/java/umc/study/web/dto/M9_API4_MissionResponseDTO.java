package umc.study.web.dto;

import lombok.Getter;

@Getter
public class M9_API4_MissionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Integer reward;
    private String status;

    public M9_API4_MissionResponseDTO(Long id, String title, String description, Integer reward, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.reward = reward;
        this.status = status;
    }
}
