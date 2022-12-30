package com.stockFacilitation.exception;

import com.stockFacilitation.exception.model.ResponseExceptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception) {

        log.error("ERROR",exception);

        var responseException = ResponseExceptionModel.builder()
                .code(1)
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(responseException, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NoSuchMethodException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleNoSuchMethodException(NoSuchMethodException exception) {

        log.error("ERROR",exception);

        var responseException = ResponseExceptionModel.builder()
                .code(1)
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(responseException, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException exception) {

        log.error("ERROR",exception);

        var responseException = ResponseExceptionModel.builder()
                .code(1)
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(responseException, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
