package juegoDeDados.S502F2.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidElementException.class)
    public ResponseEntity<String> handleInvalidElement(InvalidElementException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ElementsDoesntEqualsException.class)
    public ResponseEntity<String> handleElementsDoesntEquals(ElementsDoesntEqualsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
