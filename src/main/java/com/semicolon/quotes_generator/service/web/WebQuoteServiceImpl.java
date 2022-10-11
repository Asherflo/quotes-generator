package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import org.springframework.stereotype.Service;

@Service
public class WebQuoteServiceImpl implements WebQuoteService {

    @Override
    public CreateQuoteResponse loadWebQuote(CreateQuoteRequest createQuoteRequest) {
        return null;
    }
}
