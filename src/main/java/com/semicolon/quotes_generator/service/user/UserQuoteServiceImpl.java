package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import org.springframework.stereotype.Service;

@Service
public class UserQuoteServiceImpl implements UserQuoteService {

    @Override
    public CreateQuoteResponse createUserQuote(CreateQuoteRequest createQuoteRequest) {
        return null;
    }
}
