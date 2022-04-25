package com.ctd.clinic;

import com.ctd.clinic.exception.ResourceNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> errorNotFound(ResourceNotFoundException notFoundEx) {
        logger.error("ResourceNotFoundException: " + notFoundEx.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundEx.getMessage());
    }
}
