package pl.pjatk.movie.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException (RuntimeException rex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Rzucono wyjątek, wiadomość: " + rex.getLocalizedMessage());
    }

}
