package com.semicolon.quotes_generator.service.web;
;
import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.data.repository.WebQuoteRepository;
import com.semicolon.quotes_generator.dtos.responses.GoQuoteDto;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;
import com.semicolon.quotes_generator.dtos.responses.Quote;
import com.semicolon.quotes_generator.exceptions.WebQuoteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class WebQuoteServiceImpl implements WebQuoteService {
    private final RestTemplate restTemplate;
    private final WebQuoteRepository webQuoteRepository;

    @Override
    public LoadQuoteResponse loadWebQuotesToDatabase() {
        loadWebQuotesIntoDatabaseFromGoQuoteApi();
        return LoadQuoteResponse.builder().successful(true).build();
    }

    @Override
    public Map<String, Object> findAll(int numberOfPages, int numberOfItems) {
        Pageable pageable = PageRequest.of(numberOfPages, numberOfItems);
        Page<WebQuote> page = webQuoteRepository.findAll(pageable);

        Map<String, Object> pageResult = new HashMap<>();
        pageResult.put("totalNumberOfPages", page.getTotalPages());
        pageResult.put("totalNumberOfElementsInDatabase", page.getTotalElements());
        if (page.hasNext()){
            pageResult.put("nextPage", page.nextPageable());
        }
        if (page.hasPrevious()){
            pageResult.put("previousPage", page.previousPageable());
        }
        pageResult.put("webQuotes", page.getContent());
        pageResult.put("NumberOfElementsInPage", page.getNumberOfElements());
        pageResult.put("pageNumber", page.getNumber());
        pageResult.put("size", page.getSize());
        return pageResult;
    }


    @Override
    public List<WebQuote> findWebQuoteByAuthor(String author) {
        return webQuoteRepository.findWebQuoteByAuthor(author).orElseThrow(()->
                new WebQuoteNotFoundException("WebQuote not found!",404));
    }

    @Override
    public WebQuote findWebQuoteByQuote(String quote) {
        return webQuoteRepository.findWebQuoteByQuote(quote).orElseThrow(()->
                new WebQuoteNotFoundException("WebQuote not found!",404));
    }

    @Override
    public WebQuote findWebQuoteByQuoteNumber(int quoteNumber) {
        return webQuoteRepository.findWebQuoteByQuoteNumber(quoteNumber).orElseThrow(()->
                new WebQuoteNotFoundException("WebQuote not found!",404));
    }

    private WebQuote buildWebQuoteFrom(int count, Quote quote) {
        return WebQuote.builder()
                 .quote(quote.getText())
                 .quoteNumber(count)
                 .author(quote.getAuthor())
                 .build();
    }

    private Quote[] fetchQuoteFromGoQuoteApi(){
        GoQuoteDto goQuoteDto = restTemplate.getForObject("https://goquotes-api.herokuapp.com/api/v1/random?count=100", GoQuoteDto.class);
        return Objects.requireNonNull(goQuoteDto).getQuotes();
    }
    @Async
    void loadWebQuotesIntoDatabaseFromGoQuoteApi() {
        AtomicInteger count  = new AtomicInteger(1);
            Quote[] quotes = fetchQuoteFromGoQuoteApi();
            Arrays.stream(quotes).forEach(quote -> {
                if (!webQuoteRepository.existsByQuote(quote.getText())) {
                    WebQuote webQuote = buildWebQuoteFrom(count.getAndIncrement(),quote);
                    webQuoteRepository.save(webQuote);
                }
            });
    }
}

