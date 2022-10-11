package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.QuoteGeneratorDto;
import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.data.repository.WebQuoteRepository;
import com.semicolon.quotes_generator.exceptions.QuoteGeneratorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebQuoteServiceImpl implements WebQuoteService {

    @Autowired
    private WebQuoteRepository webQuoteRepository;

//    private QuoteGeneratorDto quoteGeneratorDto;

    @Override
    public QuoteGeneratorDto findWebQuoteByQuote(String quote) {
        WebQuote webQuote = webQuoteRepository.findWebQuoteByQuote(quote).orElseThrow(() -> new QuoteGeneratorException("There is no such quote.", 401));
        QuoteGeneratorDto quoteGeneratorDto = QuoteGeneratorDto.builder()
                .quote(webQuote.getQuote())
                .build();
        return quoteGeneratorDto;
    }

    @Override
    public QuoteGeneratorDto findWebQuoteByAuthor(String author) {
        WebQuote webQuote = webQuoteRepository.findWebQuoteByAuthor(author).orElseThrow(()-> new QuoteGeneratorException("There is no such author, enter right author", 401));
        QuoteGeneratorDto quoteGeneratorDto = QuoteGeneratorDto.builder()
                .author(webQuote.getAuthor())
                .build();
        return quoteGeneratorDto;
    }

    @Override
    public QuoteGeneratorDto findWebQuoteByQuoteNumber(int quoteNumber) {
        WebQuote webQuote = webQuoteRepository.findWebQuoteByQuoteNumber(quoteNumber).orElseThrow(()-> new QuoteGeneratorException("search query error", 401));
        QuoteGeneratorDto quoteGeneratorDto = QuoteGeneratorDto.builder()
                .quoteNumber(webQuote.getQuoteNumber())
                .build();
        return quoteGeneratorDto;
    }


}
