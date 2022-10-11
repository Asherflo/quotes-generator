package com.semicolon.quotes_generator.dtos.responses;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDto {
    private String quote;
}
