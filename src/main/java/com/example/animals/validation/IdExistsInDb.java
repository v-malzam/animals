package com.example.animals.validation;

import com.example.animals.validation.impl.IdExistsInDbValidator;

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
@Constraint(validatedBy = IdExistsInDbValidator.class)
public @interface IdExistsInDb {

    String message() default "1";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
