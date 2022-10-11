package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;

import java.util.Map;

public interface WebQuoteService {
    LoadQuoteResponse loadWebQuotesToDatabase();
    Map<String, Object> findAll(int numberOfPages, int numberOfItems);
}
