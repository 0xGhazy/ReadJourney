package com.project.ReadJourney.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDateFormatException extends RuntimeException{

    public InvalidDateFormatException(String filedName, String filedValue){
        super(String.format("%s is invalid formatted, the support format is yyyy-mm-dd you provide: %s", filedName, filedValue));
    }

}
