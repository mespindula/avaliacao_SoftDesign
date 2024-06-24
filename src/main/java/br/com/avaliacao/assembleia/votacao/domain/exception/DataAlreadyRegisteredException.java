package br.com.avaliacao.assembleia.votacao.domain.exception;


public class DataAlreadyRegisteredException extends RuntimeException {

  public DataAlreadyRegisteredException(final String message) {
    super(message);
  }
}