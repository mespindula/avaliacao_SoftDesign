package br.com.avaliacao.assembleia.votacao.domain.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DateProvider {

  public LocalDate get() {
    return LocalDate.now();
  }

  public LocalDateTime getLocalDateTime() {
    return LocalDateTime.now();
  }
}
