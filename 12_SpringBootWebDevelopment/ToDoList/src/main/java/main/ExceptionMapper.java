package main;

import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_EXTENDED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionMapper extends RuntimeException {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleRunTimeException(NotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<String> handleRunTimeException(NullPointerException e) {
        return ResponseEntity.status(NOT_EXTENDED).body(e.getMessage());
    }
}
