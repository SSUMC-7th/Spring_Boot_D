package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.ApiPayload.code.status.ErrorStatus;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.ExistCategories;
import umc.study.validation.annotation.ExistStores;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStores, Store> {
    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Store store, ConstraintValidatorContext context) {
        boolean isValid = storeRepository.existsById(store.getId());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }

}
