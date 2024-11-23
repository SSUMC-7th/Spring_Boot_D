package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.validation.annotation.ExistUser;
@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUser, Long> {

    private final MemberRepository memberRepository; // 생성자로 주입된 인스턴스 사용

    @Override
    public void initialize(ExistUser constraintAnnotation) {
        // 초기화 작업이 필요하면 여기에 작성
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // memberRepository 객체를 사용하여 existsById 호출
        boolean isValid = memberRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}