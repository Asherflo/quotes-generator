package com.semicolon.quotes_generator.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WebQuote {
    private String id;
    private String author;
    private String quote;
    private int quoteNumber;
}
