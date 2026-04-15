package com.example.restaurant.exception;


import com.example.restaurant.entity.dto.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class UserException {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseMessage> noElementFind(NoSuchElementException ex){
        ResponseMessage responseMessage = new ResponseMessage(ex.getMessage());

        return ResponseEntity.badRequest().body(responseMessage);


    }
}
