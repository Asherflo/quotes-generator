package com.semicolon.quotes_generator.service.web;
;
import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.data.repository.WebQuoteRepository;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;
import com.semicolon.quotes_generator.dtos.responses.QuoteDto;
import com.semicolon.quotes_generator.exceptions.WebQuoteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WebQuoteServiceImpl implements WebQuoteService {
    private final RestTemplate restTemplate;
    private final WebQuoteRepository webQuoteRepository;

    @Override
    public LoadQuoteResponse loadWebQuotesToDatabase() {
        loadWebQuotesIntoDatabaseFromKanyeWestApi();
        return LoadQuoteResponse.builder().successful(true).build();
    }

    @Override
    public List<WebQuote> findAll() {
        return webQuoteRepository.findAll();
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

    private WebQuote buildWebQuoteFrom(int i, String quote) {
        return WebQuote.builder()
                 .quote(quote)
                 .quoteNumber(i)
                 .author("Kanye West")
                 .build();
    }

    private String fetchQuoteFromKanyeWestApi(){
        QuoteDto quoteDto = restTemplate.getForObject("https://api.kanye.rest", QuoteDto.class);
        return Objects.requireNonNull(quoteDto).getQuote();
    }
    @Async
    void loadWebQuotesIntoDatabaseFromKanyeWestApi() {
        for (int i = 1; i <= 25; i++) {
            String quote = fetchQuoteFromKanyeWestApi();
            if (!webQuoteRepository.existsByQuote(quote)) {
                WebQuote webQuote = buildWebQuoteFrom(i, quote);
                webQuoteRepository.save(webQuote);
            }
        }
    }
}
