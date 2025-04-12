package pl.pjatk.danmak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MessageControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException (RuntimeException rex){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Rzucono wyjątek, wiadomość: " + rex.getLocalizedMessage());
    }
}
