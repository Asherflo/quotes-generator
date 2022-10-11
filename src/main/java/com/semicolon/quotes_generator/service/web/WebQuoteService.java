package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;

public interface WebQuoteService {
    CreateQuoteResponse loadWebQuote(CreateQuoteRequest createQuoteRequest);
}
