package br.com.avaliacao.assembleia.votacao.application.handler;

public class ResponseError {

  private String code;

  private String message;

  public ResponseError(final String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
