package com.project.ReadJourney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicationException extends RuntimeException{

    public DuplicationException(String resourceName, String filedName, String filedValue){
        super(String.format("Duplication found on %s resource with %s : %s", resourceName, filedName, filedValue));
    }

}
