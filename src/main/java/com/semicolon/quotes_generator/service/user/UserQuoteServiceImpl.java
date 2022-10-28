package com.semicolon.quotes_generator.service.user;

import com.semicolon.quotes_generator.data.model.UserQuote;
import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.data.repository.UserQuoteRepository;
import com.semicolon.quotes_generator.dtos.requests.CreateQuoteRequest;
import com.semicolon.quotes_generator.dtos.responses.CreateQuoteResponse;
import com.semicolon.quotes_generator.exceptions.QuoteGeneratorException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public Map<String, Object> findAll(int numberOfPages, int numberOfItems) {
        Pageable pageable = PageRequest.of(numberOfPages, numberOfItems);
        Page<UserQuote> page = userQuoteRepository.findAll(pageable);

        Map<String, Object> pageResult = new HashMap<>();
        pageResult.put("totalNumberOfPages", page.getTotalPages());
        pageResult.put("totalNumberOfElementsInDatabase", page.getTotalElements());
        if (page.hasNext()){
            pageResult.put("nextPage", page.nextPageable());
        }
        if (page.hasPrevious()){
            pageResult.put("previousPage", page.previousPageable());
        }
        pageResult.put("userQuotes", page.getContent());
        pageResult.put("NumberOfElementsInPage", page.getNumberOfElements());
        pageResult.put("pageNumber", page.getNumber());
        pageResult.put("size", page.getSize());
        return pageResult;
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
