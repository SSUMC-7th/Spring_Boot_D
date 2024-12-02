package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.enums.RestaurantCategory;
import umc.spring.validation.annotation.ExistRestaurantCategory;

public class RestaurantCategoryValidator implements ConstraintValidator<ExistRestaurantCategory, Integer> {

    @Override
    public void initialize(ExistRestaurantCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 0 || value >= RestaurantCategory.values().length) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND.toString())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}
