package com.semicolon.quotes_generator.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoQuoteDto {
    private int status;
    private String message;
    private int count;
    private Quote[] quotes;
}
