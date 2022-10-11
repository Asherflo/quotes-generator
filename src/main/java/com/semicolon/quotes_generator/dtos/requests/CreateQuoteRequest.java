package com.semicolon.quotes_generator.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuoteRequest {
    private String quote;
    private String author;
    private int quoteNumber;
}