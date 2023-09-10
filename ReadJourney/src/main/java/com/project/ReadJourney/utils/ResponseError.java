package com.project.ReadJourney.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
@AllArgsConstructor
public class ResponseError {

    private Date timestamp;
    private String message;
    private Object details;

    private HashMap<String, Object> jsonfy(){
        HashMap<String, Object> errors = new HashMap<>();
        errors.put("timestamp", this.getTimestamp());
        errors.put("message", this.getMessage());
        errors.put("details", this.getDetails());
        return errors;
    }


}
