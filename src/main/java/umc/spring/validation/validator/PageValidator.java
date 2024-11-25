package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.validation.annotation.ValidPage;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public void initialize(ValidPage constraintAnnotation) {
        // 초기화 로직 필요 시 작성
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            return false; // 페이지가 1보다 작으면 유효하지 않음
        }
        return true; // 유효한 페이지
    }
}
