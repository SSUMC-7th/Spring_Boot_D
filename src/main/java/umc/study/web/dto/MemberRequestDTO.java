package umc.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Setter
    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;

        @NotNull
        Integer gender;

        @NotBlank
        @Email
        String email;

        @NotBlank
        String password;

        @NotNull
        Integer birthYear;

        @NotNull
        Integer birthMonth;

        @NotNull
        Integer birthDay;

//        Integer age;

        @Size(min = 5, max = 12)
        String address;

        @Size(min = 5, max = 12)
        String specAddress;

        @ExistCategories
        List<Long> preferCategory;

        @NotNull
        Role role;
    }
}
