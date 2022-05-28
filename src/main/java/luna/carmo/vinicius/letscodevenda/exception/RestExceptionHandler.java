package luna.carmo.vinicius.letscodevenda.exception;

import lombok.extern.slf4j.Slf4j;
import luna.carmo.vinicius.letscodevenda.dto.DefaultErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity postNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DefaultErrorDto(ex.getMessage()));
    }
}
