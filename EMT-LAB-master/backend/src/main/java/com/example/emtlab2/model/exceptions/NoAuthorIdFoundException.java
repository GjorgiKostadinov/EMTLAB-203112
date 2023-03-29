package com.example.emtlab2.model.exceptions;

public class NoAuthorIdFoundException extends RuntimeException{
    public NoAuthorIdFoundException() {
        super("No author with this id is found.");
    }
}
