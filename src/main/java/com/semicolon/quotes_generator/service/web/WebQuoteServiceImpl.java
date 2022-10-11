package com.semicolon.quotes_generator.service.web;
;
import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.data.repository.WebQuoteRepository;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;
import com.semicolon.quotes_generator.dtos.responses.QuoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

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
    public WebQuote next() {
        return null;
    }

    @Override
    public WebQuote previous() {
        return null;
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
    private void loadWebQuotesIntoDatabaseFromKanyeWestApi() {
        for (int i = 1; i <= 500; i++) {
            String quote = fetchQuoteFromKanyeWestApi();
            if (!webQuoteRepository.existsByQuote(quote)) {
                WebQuote webQuote = buildWebQuoteFrom(i, quote);
                webQuoteRepository.save(webQuote);
            }
        }
    }
}
