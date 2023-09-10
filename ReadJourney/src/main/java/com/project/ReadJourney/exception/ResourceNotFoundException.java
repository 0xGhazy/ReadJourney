package com.project.ReadJourney.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND) // make status always Not_Found whenever this exception thrown.
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName,
                                     String filedName,
                                     Long filedValue){
        super(String.format("%s not found with %s : %s", resourceName, filedName, filedValue));
    }
}
