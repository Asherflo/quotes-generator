package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;

import java.util.List;


public interface WebQuoteService {
    LoadQuoteResponse loadWebQuotesToDatabase();
    List<WebQuote> findAll();
    List<WebQuote> findWebQuoteByAuthor(String author);
    WebQuote findWebQuoteByQuote(String quote);
    WebQuote findWebQuoteByQuoteNumber(int quoteNumber);
}
