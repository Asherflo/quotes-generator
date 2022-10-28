package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import java.util.List;
import java.util.Map;

public interface UserQuoteService {
    CreateQuoteResponse createUser(CreateQuoteRequest  quoteRequest) ;
    Map<String, Object> findAll(int numberOfPages, int numberOfItems);
    UserQuote findByQuoteNumber(int i);

    List<UserQuote> findAll();


    void deleteAll();
}
