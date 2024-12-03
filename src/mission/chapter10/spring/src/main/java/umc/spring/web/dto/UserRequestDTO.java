package umc.spring.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

import java.util.ArrayList;
import java.util.List;

public class UserRequestDTO {

    @Getter
    @Setter
    public static class JoinDto {
        @NotBlank
        String nickname;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> userPreferredFoodList = new ArrayList<>();
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Role role;
    }

}
