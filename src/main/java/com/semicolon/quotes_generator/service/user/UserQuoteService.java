package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;

public interface UserQuoteService {
    CreateQuoteResponse createUserQuote(CreateQuoteRequest createQuoteRequest);
}
