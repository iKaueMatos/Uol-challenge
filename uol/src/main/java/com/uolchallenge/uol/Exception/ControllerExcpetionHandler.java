package com.uolchallenge.uol.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExcpetionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity threatNoSuchElementException(NoSuchElementException exception){
        ExceptionDTO dto = new ExceptionDTO("Essa lista não possui mais usuários disponíveis", "400");
        return ResponseEntity.badRequest().body(dto);
    }
}
