package com.semicolon.quotes_generator.controller;

import com.mongodb.lang.NonNull;
import com.semicolon.quotes_generator.data.model.WebQuote;
import com.semicolon.quotes_generator.dtos.responses.ApiResponse;
import com.semicolon.quotes_generator.dtos.responses.LoadQuoteResponse;
import com.semicolon.quotes_generator.service.web.WebQuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/web-quote")
public class WebQuoteController {
    private final WebQuoteService webQuoteService;

    @GetMapping("/load-quotes")
    public ResponseEntity<?> loadQuotesToDatabase() {
        LoadQuoteResponse response = webQuoteService.loadWebQuotesToDatabase();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{author}")
    public ResponseEntity<?> findWebQuoteByAuthor(@PathVariable String author) {
        List<WebQuote> dtoList = webQuoteService.findWebQuoteByAuthor(author);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("quoteNumber/{quoteNumber}")
    public ResponseEntity<?> findWebQuoteByQuoteNumber(@PathVariable int quoteNumber) {
        WebQuote webQuote = webQuoteService.findWebQuoteByQuoteNumber(quoteNumber);
        return new ResponseEntity<>(webQuote, HttpStatus.OK);
    }

    @GetMapping("quote/{quote}")
    public ResponseEntity<?> findWebQuoteByQuote(@PathVariable String quote) {
        WebQuote webQuote = webQuoteService.findWebQuoteByQuote(quote);
        return new ResponseEntity<>(webQuote, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllQuotes() {
        List<WebQuote> webQuoteList = webQuoteService.findAll();
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("pages returned")
                .data(webQuoteList)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
