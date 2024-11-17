package umc.study.web.dto;

public class API1_StoreResponseDTO {
    private Long id;
    private String name;
    private String address;

    public API1_StoreResponseDTO(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
