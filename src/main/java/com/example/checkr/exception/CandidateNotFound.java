package com.example.checkr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class CandidateNotFound extends RuntimeException{
    private String message;
    public CandidateNotFound(String message)
    {
        super(message);
        this.message=message;
    }
}
