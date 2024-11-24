package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MissionAssignedExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionAssignedExistValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMissionAssigned {

    String message() default "미션이 이미 할당되었습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}