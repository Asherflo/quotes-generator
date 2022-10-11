package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;

public interface WebQuoteService {
    LoadQuoteResponse loadWebQuotesToDatabase();

    WebQuote next();

    WebQuote previous();
}
