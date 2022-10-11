package com.semicolon.quotes_generator.controller;

import com.semicolon.quotes_generator.QuoteGeneratorDto;
import com.semicolon.quotes_generator.service.web.WebQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebQuoteController {

    @Autowired
    private WebQuoteService webQuoteService;


    @GetMapping("/{findWebQuoteByQuote}")
    public ResponseEntity<?> findWebQuoteByQuote(@PathVariable("findWebQuoteByQuote") String quote){
        QuoteGeneratorDto quoteGeneratorDto = webQuoteService.findWebQuoteByQuote(quote);
        return new ResponseEntity<>(quoteGeneratorDto, HttpStatus.FOUND);
    }

    @GetMapping("/{findWebQuoteByAuthor}")
    public ResponseEntity<?> findWebQuoteByAuthor(@PathVariable("findWebQuoteByAuthor") String author){
        QuoteGeneratorDto quoteGeneratorDto = webQuoteService.findWebQuoteByAuthor(author);
        return new ResponseEntity<>(quoteGeneratorDto, HttpStatus.FOUND);
    }

    @GetMapping("/{findWebQuoteByQuoteNumber}")
    public ResponseEntity<?> findWebQuoteByQuoteNumber(@PathVariable("findWebQuoteByQuoteNumber") int quoteNumber){
        QuoteGeneratorDto quoteGeneratorDto = webQuoteService.findWebQuoteByQuoteNumber(quoteNumber);
        return new ResponseEntity<>(quoteGeneratorDto, HttpStatus.FOUND);
    }
}
