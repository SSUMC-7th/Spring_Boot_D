package umc.study.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.PagesExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PagesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistPages {

    String message() default "해당하는 페이지가 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
