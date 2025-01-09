package com.jack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(Exception ex) {
        ResponseMsg responseMsg = ResponseMsg.builder()
                .msg(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .success(false)
                .build();

        return new ResponseEntity<>(responseMsg, HttpStatus.NOT_FOUND);
    }
}
