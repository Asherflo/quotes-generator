package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import java.util.List;
public interface UserQuoteService {
    CreateQuoteResponse createUser(CreateQuoteRequest  quoteRequest) ;


    UserQuote findByQuoteNumber(int i);

    List<UserQuote> findAll();


    void deleteAll();
}
