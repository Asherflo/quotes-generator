package com.semicolon.quotes_generator.service.web;

import com.semicolon.quotes_generator.QuoteGeneratorDto;


public interface WebQuoteService {
    QuoteGeneratorDto findWebQuoteByQuote(String quote);

    QuoteGeneratorDto findWebQuoteByAuthor(String author);

    QuoteGeneratorDto findWebQuoteByQuoteNumber(int quoteNumber);





}
