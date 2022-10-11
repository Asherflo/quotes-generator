package com.semicolon.quotes_generator.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(QuoteGeneratorException.class)
    public ResponseEntity<?> handleQuoteGeneratorException(QuoteGeneratorException quoteGeneratorException) {
        ApiError apiError = ApiError.builder()
                .statusCode(406)
                .message(quoteGeneratorException.getMessage())
                .successful(false)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(WebQuoteNotFoundException.class)
    public ResponseEntity<?> handleWebQuoteNotFoundException(WebQuoteNotFoundException webQuoteNotFoundException) {
        ApiError apiError = ApiError.builder()
                .statusCode(406)
                .message(webQuoteNotFoundException.getMessage())
                .successful(false)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_ACCEPTABLE);
    }

}
