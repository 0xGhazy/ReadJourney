package com.project.ReadJourney.exception;

import com.project.ReadJourney.utils.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handleResourceNotFoundException(
            ResourceNotFoundException exception,
            WebRequest webRequest)
    {
        ResponseError error = new ResponseError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicationException.class)
    public ResponseEntity<ResponseError> handleDuplicationException(
            DuplicationException exception,
            WebRequest webRequest)
    {
        ResponseError error = new ResponseError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ResponseError> handleDateFormatException(
            InvalidDateFormatException exception,
            WebRequest webRequest)
    {
        ResponseError error = new ResponseError(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleAllErrors(MethodArgumentNotValidException ex){
////        ResponseError error = new ResponseError(new Date(), exception.getMessage(), webRequest.getDescription(false));
//        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
//    }



}
