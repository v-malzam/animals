package com.example.animals.validation.annotation;

import com.example.animals.validation.validator.DoubleNameInDbValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DoubleNameInDbValidator.class)
public @interface DoubleNameInDb {

    String message() default "Double Name found in database";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
