package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.validation.annotation.ExistRestaurant;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantRepository.existsById(value);

        if (!isValid) {
            System.out.println("HERE");
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }

}
