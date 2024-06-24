package br.com.avaliacao.assembleia.votacao.application.handler;

import br.com.avaliacao.assembleia.votacao.domain.exception.DataAlreadyRegisteredException;
import br.com.avaliacao.assembleia.votacao.domain.exception.DataNotFoundException;
import br.com.avaliacao.assembleia.votacao.domain.exception.util.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.springframework.http.ResponseEntity.*;

@ControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<ResponseMessages> handleDataNotFoundException(final DataNotFoundException exception) {
    if (isNull(exception.getMessage())) {
      return notFound().build();
    }

    return status(HttpStatus.NOT_FOUND)
        .body(buildMessages(exception.getMessage(), exception.getExceptionCode()));
  }

  @ExceptionHandler(DataAlreadyRegisteredException.class)
  public ResponseEntity<ResponseMessages> handleDataAlreadyRegisteredException(
          final DataAlreadyRegisteredException dataAlreadyRegisteredException) {
    return status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(buildMessages(dataAlreadyRegisteredException.getMessage(), ""));
  }

  private ResponseMessages buildMessages(final String message, final ExceptionCode exceptionCode) {
    return buildMessages(message, nonNull(exceptionCode) ? exceptionCode.getExceptionCode() : null);
  }

  private ResponseMessages buildMessages(final String message, final String exceptionCode) {
    final ResponseMessages responseMessages = new ResponseMessages();
    responseMessages.addMessage(message);
    if (isNotBlank(exceptionCode)) {
      responseMessages.addError(exceptionCode, message);
    }
    return responseMessages;
  }
}