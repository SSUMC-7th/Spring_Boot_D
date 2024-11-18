package umc.study.web.dto;

import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO {
        Long storeId;
        Long memberId;
        String nickname;
        String description;
        float rating;
        List<String> images;
    }
}
