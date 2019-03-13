package com.stackroute.foodservice.globalexceptions;
/*
Handles customised exceptions which is specified in the parameter.
 */
import com.stackroute.foodservice.exceptions.UserAlreadyExistsException;
import com.stackroute.foodservice.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({UserAlreadyExistsException.class, UserNotFoundException.class})
    public ResponseEntity<String> exceptions(Exception e) {
        return new ResponseEntity<String>("Global Exception thrown here:" + e.getMessage(), HttpStatus.CONFLICT);
    }
}
