package rs.java.library.controller;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import rs.java.library.exception.InvalidIdException;
import rs.java.library.model.ApiError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handlerNullPointer(NullPointerException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR, "INVALID COUNTRY CODE");
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<Object> handlerInvalidBookId(InvalidIdException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}