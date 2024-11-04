package com.ar.mikellbobadilla.app.advice;

import com.ar.mikellbobadilla.app.exceptions.ResourceException;
import com.ar.mikellbobadilla.app.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class ControllerExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    ErrorResponse resourceNotFoundExceptionHandler(ResourceNotFoundException exc) {
        log.warn("Not found resource", exc.getCause());
        return new ErrorResponse(NOT_FOUND.value(), exc.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ResourceException.class)
    ErrorResponse resourceExceptionHandler(ResourceException exc) {
        log.warn("Error with resource", exc.getCause());
        return new ErrorResponse(BAD_REQUEST.value(), exc.getMessage());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    ErrorResponse serverExceptionsHandler(RuntimeException exc) {
        log.error(exc.getMessage(), exc.getCause());
        return new ErrorResponse(INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
    }
}
