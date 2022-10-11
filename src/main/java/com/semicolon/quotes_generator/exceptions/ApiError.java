package com.semicolon.quotes_generator.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ApiError {
    private boolean successful;
    private int statusCode;
    private String message;
}
