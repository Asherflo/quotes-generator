package com.semicolon.quotes_generator.exceptions;

public class QuoteGeneratorException extends RuntimeException {
    private int statusCode;
    public QuoteGeneratorException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
