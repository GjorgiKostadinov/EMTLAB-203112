package com.example.emtlab2.model.exceptions;

public class NoCountryIdFoundException extends RuntimeException{
    public NoCountryIdFoundException() {
        super("No country with this id is found.");
    }
}
