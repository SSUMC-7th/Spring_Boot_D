package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.Store;
import umc.spring.validation.annotation.ExistUser;

import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDto{
        @ExistUser
        Long userId;

        Store storeId;

        @Size(min = 1, max = 50)
        String title;

        @Size(min = 1, max = 1000)
        String content;

        @NotNull
        Float rating;

    }
}
