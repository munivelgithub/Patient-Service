package com.muni.Patient.Service.globalException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
   // handle any of the validation error that triger this exception handler
   //   this exception error handling is fo rmethod argument not valide error
    // if the user send an wrong typr of an input
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException e){
//
//    }
    // budinees logic error code
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String,String>> emailalreadyexist(EmailAlreadyExistException ex){
        Map<String,String> error=new HashMap<>();
        error.put("message","Email already exist");
        return ResponseEntity.badRequest().body(error);
    }
    // logger

}
