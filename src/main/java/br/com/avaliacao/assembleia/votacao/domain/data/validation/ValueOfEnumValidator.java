package br.com.avaliacao.assembleia.votacao.domain.data.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {

  private String message;
  private List<String> values;
  private String acceptedValues;

  @Override
  public void initialize(final ValueOfEnum annotation) {
    this.values = Stream.of(annotation.enumClass().getEnumConstants())
        .map(Enum::name)
        .collect(Collectors.toList());
    this.message = annotation.message();
    this.acceptedValues = String.join(", ", values);
  }

  @Override
  public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {
    if (isBlank(value)) {
      return true;
    }

    if (!values.contains(value.toString())) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(message.replace("{enumClass}", acceptedValues)).addConstraintViolation();
      return false;
    }

    return true;
  }
}