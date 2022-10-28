package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;

import java.util.List;
import java.util.Map;


public interface WebQuoteService {
    LoadQuoteResponse loadWebQuotesToDatabase();
    Map<String, Object> findAll(int numberOfPages, int numberOfItems);
    List<WebQuote> findWebQuoteByAuthor(String author);
    WebQuote findWebQuoteByQuote(String quote);
    WebQuote findWebQuoteByQuoteNumber(int quoteNumber);
}
