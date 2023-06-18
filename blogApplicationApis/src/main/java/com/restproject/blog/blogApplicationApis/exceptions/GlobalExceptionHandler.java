package com.restproject.blog.blogApplicationApis.exceptions;

import com.restproject.blog.blogApplicationApis.payloads.ApiResponse;
import com.restproject.blog.blogApplicationApis.payloads.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest request){
        String message = ex.getMessage();
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), new Date(),message,request.getDescription(false));
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex, WebRequest request){

        Map<String,String> resp = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName,message);
        });

        ex.getFieldErrors().stream().forEach(System.out::println);
        String message = ex.getMessage();
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), new Date(),resp.toString(),request.getDescription(false));
        return response;
    }

}
