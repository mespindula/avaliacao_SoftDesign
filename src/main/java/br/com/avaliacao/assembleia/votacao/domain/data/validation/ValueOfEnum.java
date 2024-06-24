package br.com.avaliacao.assembleia.votacao.domain.data.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
  Class<? extends Enum<?>> enumClass();

  String message() default "must be any enum of {enumClass}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}