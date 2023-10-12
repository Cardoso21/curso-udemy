package br.com.udemy.cursoudemy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SuportException extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    public SuportException(String ex) {
        super(ex);
    }
}
