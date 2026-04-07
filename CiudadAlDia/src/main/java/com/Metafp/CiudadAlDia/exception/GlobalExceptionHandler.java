package com.Metafp.CiudadAlDia.exception;

import com.Metafp.CiudadAlDia.payload.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> apiResponseMessageResponse(ResourceNotFoundException resourceNotFoundException){
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
                .success(false)
                .message(resourceNotFoundException.getMessage())
                .data(null)
                .status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiResponseMessage,HttpStatus.NOT_FOUND);
    }



}
