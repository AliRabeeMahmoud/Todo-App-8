package com.ali.java.todo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeTypeValidator.class)
public @interface ValidateAgeType {

    public String message() default "Invalid. only allowed: child, teenager, adult, old";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
