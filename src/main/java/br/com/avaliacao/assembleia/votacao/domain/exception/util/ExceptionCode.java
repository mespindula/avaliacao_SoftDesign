package br.com.avaliacao.assembleia.votacao.domain.exception.util;

import java.util.List;

public enum ExceptionCode {

  ;

  private final String exceptionCode;

  private final List<Class> ableClasses;

  ExceptionCode(final String exceptionCode, final List<Class> ableClasses) {
    this.exceptionCode = exceptionCode;
    this.ableClasses = ableClasses;
  }

  public String getExceptionCode() {
    return exceptionCode;
  }

  public List<Class> getAbleClasses() {
    return ableClasses;
  }

}