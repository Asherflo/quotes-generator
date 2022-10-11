package com.semicolon.quotes_generator.data.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class WebQuote {
    private String id;
    private String author;
    private String quote;
    private int quoteNumber;
}
