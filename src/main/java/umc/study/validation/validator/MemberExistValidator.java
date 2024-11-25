package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.ApiPayload.code.status.ErrorStatus;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.validation.annotation.ExistCategories;
import umc.study.validation.annotation.ExistMembers;
import umc.study.validation.annotation.ExistPages;


@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMembers, Integer> {

    private final MemberRepository memberRepository;

    @Override
    public void initialize(ExistMembers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer memberId, ConstraintValidatorContext context) {

        boolean isValid = memberRepository.existsById(memberId);


        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
