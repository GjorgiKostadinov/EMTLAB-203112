package com.example.emtlab2.model.exceptions;

public class NoCopiesLeftException extends RuntimeException {
    public NoCopiesLeftException() {
        super("There are no more copies of this book.");
    }
}
