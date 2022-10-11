package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.data.repository.UserQuoteRepository;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import com.semicolon.quotes_generator.exceptions.QuoteGeneratorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQuoteServiceImpl implements UserQuoteService {
    private final UserQuoteRepository userQuoteRepository;


    @Override
    public CreateQuoteResponse createUser(CreateQuoteRequest quoteRequest)  {
        CreateQuoteResponse quoteResponse = new CreateQuoteResponse();
        UserQuote userQuote = new UserQuote();
        userQuote.setAuthor(quoteRequest.getAuthor());
        userQuote.setQuoteNumber(quoteRequest.getQuoteNumber());
        userQuote.setQuote(quoteRequest.getQuote());
        UserQuote registerQuote = userQuoteRepository.save(userQuote);
        quoteResponse.setUserQuote(registerQuote);
        quoteResponse.setMessage("Quote Created");
        return quoteResponse;
    }


    @Override
    public UserQuote findByQuoteNumber(int quoteNumber)throws QuoteGeneratorException {
        return userQuoteRepository.findByQuoteNumber(quoteNumber);
    }

    @Override
    public List<UserQuote> findAll() throws QuoteGeneratorException {
        return userQuoteRepository.findAll();
    }

    @Override
    public void deleteAll() {

         userQuoteRepository.deleteAll();
    }


}

