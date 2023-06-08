package com.shreek.crudapp.exception;

import com.shreek.crudapp.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException exception, WebRequest request) {
        String errorMessage = exception.getMessage();
        int httpStatusCode = 500;
        if (exception.getErrorCode()!= 0) httpStatusCode = exception.getErrorCode();
        ExceptionDTO exceptionResponseDTO = new ExceptionDTO();
        exceptionResponseDTO.setErrorMessage(errorMessage);
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.valueOf(httpStatusCode));
    }
}