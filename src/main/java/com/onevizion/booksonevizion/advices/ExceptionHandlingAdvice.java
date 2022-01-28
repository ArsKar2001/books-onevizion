package com.onevizion.booksonevizion.advices;

import com.onevizion.booksonevizion.models.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> defaultHandle(Exception e) {
        ResponseModel response = new ResponseModel(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
