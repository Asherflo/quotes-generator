package com.semicolon.quotes_generator.dtos.responses;

import com.semicolon.quotes_generator.data.model.UserQuote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuoteResponse {
    private String message;
    private UserQuote userQuote;
}