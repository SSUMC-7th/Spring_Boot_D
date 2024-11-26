package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistStore;


public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private StoreRepository storeRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        // 초기화 작업이 필요하면 여기에 작성
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        boolean isValid = storeRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
