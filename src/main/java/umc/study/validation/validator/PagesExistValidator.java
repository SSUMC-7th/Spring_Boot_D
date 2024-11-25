package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.ApiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.validation.annotation.ExistPages;

@Component
@RequiredArgsConstructor
public class PagesExistValidator implements ConstraintValidator<ExistPages, Integer> {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistPages constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        boolean isValid = page > 0;

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;

    }
}
