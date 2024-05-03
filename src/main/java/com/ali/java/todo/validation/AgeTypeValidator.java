package com.ali.java.todo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class AgeTypeValidator implements ConstraintValidator<ValidateAgeType, String> {
    @Override
    public boolean isValid(String ageType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> ageTypes = Arrays.asList("child", "teenager", "adult", "old");
        return ageTypes.contains(ageType);
    }
}
