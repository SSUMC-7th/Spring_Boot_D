package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.annotations.Target;
import umc.spring.validation.validator.UserExistValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = UserExistValidator.class)
//@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUser {

    String message() default "존재하지 않는 사용자입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}