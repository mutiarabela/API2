package com.restapi.airlines.exception;

import com.restapi.airlines.model.response.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerUserNotFoundException(UserNotFoundException ex) {
        System.out.println(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                .message("User ID you sent is invalid / not match")
                .errors(new String[]{ex.getMessage()})
                .build()
        );
    }

    @ExceptionHandler({AirlineNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerAirlineNotFoundException(AirlineNotFoundException ex) {
        System.out.println(ex.getMessage());

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                        .message("Airline ID you sent is invalid / not match")
                        .errors(new String[]{ex.getMessage()})
                        .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        System.out.println(ex.getMessage());

        String[] errors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + " " + f.getDefaultMessage())
                .toArray(String[]::new);

        return ResponseEntity.badRequest()
                .body(ErrorMessage.builder()
                .message("Argument is invalid / not match")
                .errors(errors)
                .build()
        );
    }
}
