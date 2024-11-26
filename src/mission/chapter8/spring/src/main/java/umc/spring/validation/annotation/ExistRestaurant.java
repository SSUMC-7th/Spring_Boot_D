package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.RestaurantExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RestaurantExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRestaurant {

    String message() default "해당하는 식당이 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}