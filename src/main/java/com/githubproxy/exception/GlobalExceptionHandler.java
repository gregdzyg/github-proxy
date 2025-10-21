package com.githubproxy.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ApiError> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_ACCEPTABLE.value(),
                "This api only accept 'application/json' header");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiError);
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<ApiError> handleFeignNotFoundException(FeignException.NotFound e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(),
                "Github user not found or does not exist");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

}
