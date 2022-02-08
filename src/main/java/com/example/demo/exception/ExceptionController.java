package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({UserException.class})
    public ResponseEntity geterror(UserException userException , WebRequest webRequest){

        return new ResponseEntity(userException.getMessage() , HttpStatus.NOT_IMPLEMENTED);

    }

}
