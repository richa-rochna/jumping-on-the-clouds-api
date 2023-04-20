package com.jotc.api.exception.handler;

import com.jotc.api.exception.BadRequestException;
import com.jotc.api.exception.InternalException;
import com.jotc.api.exception.NotFoundException;
import com.jotc.api.exception.model.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        log.error("Not found exception", e);
        return ResponseEntity
                .status(NOT_FOUND)
                .body(ErrorModel.builder()
                        .errorMessage(e.getMessage())
                        .build());
    }

    @ExceptionHandler({BadRequestException.class, MissingRequestValueException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        log.error("Bad request exception", e);
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ErrorModel.builder()
                        .errorMessage(e.getMessage())
                        .build());
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<Object> handleInternalServerException(InternalException e) {
        log.error("Internal server exception", e);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ErrorModel.builder()
                        .errorMessage(e.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e) {
        log.error("Something went bad", e);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ErrorModel.builder()
                        .errorMessage("internal exception occurred")
                        .build());
    }
}
