package com.semicolon.quotes_generator;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuoteGeneratorDto {

    private String author;

    private String quote;

    private int quoteNumber;
}
