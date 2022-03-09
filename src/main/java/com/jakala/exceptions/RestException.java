package com.jakala.exceptions;

import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.support.DefaultMessageSourceResolvable;

@ControllerAdvice
public class RestException {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception exception, Errors errors) {
        String errorMessages = errors.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(" "));
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
}
