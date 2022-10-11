package com.semicolon.quotes_generator.exceptions;

public class WebQuoteNotFoundException extends RuntimeException {
    private int statusCode;
    public WebQuoteNotFoundException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
